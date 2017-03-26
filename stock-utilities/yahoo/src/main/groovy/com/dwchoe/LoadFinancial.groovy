package com.dwchoe

import org.grails.io.support.ClassPathResource
import org.grails.io.support.Resource

import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.PUT
import static groovyx.net.http.ContentType.*

import groovy.json.JsonOutput
import grails.plugins.rest.client.RestBuilder
import groovyx.net.http.*
import net.sf.json.*

/**
 * Created by daewonchoe on 10/16/16.
 */

public static void main(String[] args) {
    println("starting up...")
    start()
}

void start() {
    String myCompanies = readFile()
    println "myCompanies: " + myCompanies
    String url = "http://download.finance.yahoo.com/d/quotes.csv?s=" + myCompanies + "&f=sl1b4f6erj4ys1&e=.csv"
    println "url: " + url

    InputStream input = url.toURL().openStream()
    BufferedReader reader = new BufferedReader(new InputStreamReader(input))

    String line;
    while ((line = reader.readLine()) != null) {
        String[] items = line.split(",")
        println("symbol:" + items[0] + "| price:" + items[1] + "| book value:" + items[2] + "| float shares:" + items[3]
                + " | eps:" + items[4] + " | PE:" + items[5] + " | ebita:" + items[6] + " | divident yield:" + items[7]
                + " | shared owned:" + items[8])

        if (Float.parseFloat(items[1]) < Float.parseFloat(items[2])) {
            println("value stock - symbol:" + items[0])
        }

        insertIntoElasticSearch(line)
    }
}

public String readFile() {
    String[] companyEntry = null;
    List companyList = new ArrayList<String>();
    String allCompanies = null

    // load from src/main/resources directory
    ClassLoader.getSystemResourceAsStream('stocks-500.txt').getText().eachLine { line ->
        companyEntry = line.split(",")
        companyList.add(companyEntry[0])
    }

    allCompanies = String.join("+",companyList)
    return allCompanies
}

void insertIntoElasticSearch(String record) {
    String[] items = record.split(",")
    println("symbol:" + items[0] + "| price:" + items[1] + "| book value:" + items[2])

    HTTPBuilder httpBuilder = new HTTPBuilder("http://localhost:9200/stocks/stock/" + items[0].replace('"',''))

    String float_share = items[3].replaceAll("N/A","0")
    String pe = items[5].replaceAll("N/A","0")
    String div = items[7].replaceAll("N/A","0")
    println "div:" + div
    def jsonBody = [:]
    jsonBody.put("symbol",items[0].replace('"',''))
    jsonBody.put("price",items[1])
    jsonBody.put("book_value",items[2])
    jsonBody.put("float_share",float_share)
    jsonBody.put("eps",items[4])
    jsonBody.put("pe",pe)
    jsonBody.put("EBITDA",items[6])
    jsonBody.put("divdend_yield",div)
    jsonBody.put("ts","2016-10-20")

    def js = JsonOutput.toJson(jsonBody)
    println "js: " + js

    def response = httpBuilder.request(PUT, ContentType.JSON) {req ->
        body = js

        response.success = {
             resp, reader ->
                 println "response status: ${resp.statusLine}"
                 println 'Headers: -----------'
                 resp.headers.each { h ->
                     println " ${h.name} : ${h.value}"
                 }
        }
    }
}