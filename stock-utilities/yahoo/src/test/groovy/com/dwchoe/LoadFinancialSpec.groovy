package com.dwchoe

import spock.lang.Specification

/**
 * Created by daewonchoe on 10/25/16.
 */
class LoadFinancialSpec extends Specification {

    def "readFile"() {
        given:
        LoadFinancial lf = new LoadFinancial()

        when:
        String companies = lf.readFile()
        int count = companies.count('+')

        then:
        companies != null

        503 == count
    }
}
