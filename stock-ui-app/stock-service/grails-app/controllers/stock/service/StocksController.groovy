package stock.service

import com.dwchoe.domain.Stock

class StocksController {

    def read() {
        System.out.println("StocksController - read()")

        def d = Stock.list()
        println("Stock:" + d)
        render contentType: "text/json", text: '{"symbol":"BAC","current_price":"10.56"}'
    }
}
