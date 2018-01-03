package main

import groovy.sql.Sql;

def sql = Sql.newInstance("jdbc:postgresql://localhost:5432/postgres", "daewonchoe", "",
        "org.postgresql.Driver")

/*
 * Display All the records in table Person
 */

float sp500Balance = 30000
float longTermBond = 40000
float intermediateTermBond = 15000
float gold = 7500
float commodities = 7500

calc(sql, 100000, 0, 0, 0, 0)

calc(sql, sp500Balance, longTermBond, intermediateTermBond, gold, commodities)

calc(sql, 70000, 0, 15000, 7500, 7500)

def calc(def sql, float sp500Balance, float longTermBond, float intermediateTermBond, float gold, float commodities) {
    def sp500BalanceInitial = sp500Balance
    def longTermBondInitial = longTermBond
    def intermediateTermBondInitial = intermediateTermBond
    def goldInitial = gold
    def commoditiesInitial = commodities

    def queryAll = "select * from historic_return order by category,year;"
    sql.eachRow queryAll, { record ->
        if ("10YR Treasury".equals(record.category)) {
            longTermBond = longTermBond + (longTermBond * (record.return / 100))
//            println 'year:' + record.year + '- balance:' + longTermBond
        }

        if ("5YR Treasury".equals(record.category)) {
            intermediateTermBond = intermediateTermBond + (intermediateTermBond * (record.return / 100))
//            println 'year:' + record.year + '- balance:' + intermediateTermBond
        }

        if ("Commodity".equals(record.category)) {
            commodities = commodities + (commodities * (record.return / 100))
//            println 'year:' + record.year + '- balance:' + commodities
        }

        if ("Gold".equals(record.category)) {
            gold = gold + (gold * (record.return / 100))
//            println 'year:' + record.year + '- balance:' + gold
        }

        if ("SP500".equals(record.category)) {
            sp500Balance = sp500Balance + (sp500Balance * (record.return / 100))
            println 'year: ' + record.year
        }
    }

    println 'CATEGORY                      INVESTED         RETURN'
    println 'SP 500:                  ' + dollarFormat(sp500BalanceInitial) + '  ' + dollarFormat(sp500Balance)
    println 'long-term bonds:         ' + dollarFormat(longTermBondInitial) + '  ' + dollarFormat(longTermBond)
    println 'intermediate-term bonds: ' + dollarFormat(intermediateTermBondInitial) + '  ' + dollarFormat(intermediateTermBond)
    println 'gold:                    ' + dollarFormat(goldInitial) + '  ' + dollarFormat(gold)
    println 'commodities:             ' + dollarFormat(commoditiesInitial) + '  ' + dollarFormat(commodities)
    println 'total:                   ' + dollarFormat(sp500BalanceInitial + longTermBondInitial + intermediateTermBondInitial + goldInitial + commoditiesInitial) + '  ' + dollarFormat(sp500Balance + longTermBond + intermediateTermBond + gold + commodities)

    println ' '
}

def dollarFormat(def value) {
    def formatter = java.text.NumberFormat.currencyInstance
    def formatted = formatter.format(value)
    def formattedValue = formatted.padLeft(formatted*.length().max())
    return printFormat(formattedValue)
}

def printFormat(String value) {
    String formatted
    if ( value.length() == 13 ) {
        formatted = value
    }
    else if ( value.length() == 12 ) {
        formatted = " " + value
    }
    else if ( value.length() == 11 ) {
        formatted = "  " + value
    }
    else if ( value.length() == 10 ) {
        formatted = "   " + value
    }
    else if ( value.length() == 9 ) {
        formatted = "    " + value
    }
    else if ( value.length() == 8 ) {
        formatted = "     " + value
    }
    else if ( value.length() == 7 ) {
        formatted = "      " + value
    }
    else if ( value.length() == 6 ) {
        formatted = "       " + value
    }
    else if ( value.length() == 5 ) {
        formatted = "        " + value
    }
    return formatted
}