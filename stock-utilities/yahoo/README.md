# Yahoo Utility

API Doc <br>
* API doc: http://internetbandaid.com/2009/03/31/yahoo-stocks-api
* sample URL: http://ca.finance.yahoo.com/d/quotes.csv?s=BAC&f=b4&e=.csv
* s = stock
* l1 = last trade price
* b = bid
* b4 = book value
* reference URL: https://finance.yahoo.com/quote/BAC/key-statistics?p=BAC

Adding HTTPBuilder <br>
* HTTPBuilder required 'org.codehaus.groovy.modules.http-builder'
* build.gradle add runtime ":rest:0.7" in plugins section
* http://coderberry.me/blog/2012/05/07/stupid-simple-post-slash-get-with-groovy-httpbuilder/

elastic search <br>
 * create stocks index
 * curl -XPUT 'http://localhost:9200/stocks/'
 * stock mapping
 * curl -XPUT 'localhost:9200/stocks/stock/_mapping' -d '{"stock":{"properties":{"symbol":{"type":"string"},"price":{"type":"double"},"book_value":{"type":"double"},"ts":{"type":"date","format":"strict_date_optional_time||epoch_millis"}}}}'
 * insert
 * curl -XPUT 'localhost:9200/stocks/stock/BAC' -d '{"symbol":"BAC","price":"16.67","book_value":"24.19","ts":"2016-10-20"}'
 *
 * check if book value is greater than price - comparing two fields
 * query: {"constant_score":{"filter":{"script" : { "script" : "doc['price'].value < doc['book_value'].value"}}}}
 * elasticsearch.yml - required changes
 * script.engine.groovy.inline.aggs: true
 * script.engine.groovy.inline.search: true
 
<br>
kibana <br>
 * query: book_value:>20 AND price:<20
