package main

import groovy.sql.Sql;

def sql = Sql.newInstance("jdbc:postgresql://localhost:5432/postgres", "daewonchoe", "",
        "org.postgresql.Driver")

/*
 * Display All the records in table Person
 */

float totalBalance = 100000
def query = "select * from historic_return where category='SP500' order by year;"
sql.eachRow query, { record ->
    totalBalance = totalBalance + (totalBalance * (record.return / 100))
    println 'year:' + record.year + '- balance:' + totalBalance
}

println ''

float sp500Balance = 30000
float longTermBond = 40000
float intermediateTermBond = 15000
float gold = 7500
float commodities = 7500
def queryAll = "select * from historic_return order by category,year;"
sql.eachRow queryAll, { record ->
    if ( "10YR Treasury".equals(record.category) ) {
        longTermBond = longTermBond + (longTermBond * (record.return / 100))
        println 'year:' + record.year + '- balance:' + longTermBond
    }

    if ( "5YR Treasury".equals(record.category) ) {
        intermediateTermBond = intermediateTermBond + (intermediateTermBond * (record.return / 100))
        println 'year:' + record.year + '- balance:' + intermediateTermBond
    }

    if ( "Commodity".equals(record.category) ) {
        commodities = commodities + (commodities * (record.return / 100))
        println 'year:' + record.year + '- balance:' + commodities
    }

    if ( "Gold".equals(record.category) ) {
        gold = gold + (gold * (record.return / 100))
        println 'year:' + record.year + '- balance:' + gold
    }

    if ( "SP500".equals(record.category) ) {
        sp500Balance = sp500Balance + (sp500Balance * (record.return / 100))
        println 'year:' + record.year + '- balance:' + sp500Balance
    }
}

println 'SP 500:' + sp500Balance
println 'long-term bonds:' + longTermBond
println 'intermediate-term bonds' + intermediateTermBond
println 'gold:' + gold
println 'commodities:' + commodities

println 'total:' + (sp500Balance + longTermBond + intermediateTermBond + gold + commodities)