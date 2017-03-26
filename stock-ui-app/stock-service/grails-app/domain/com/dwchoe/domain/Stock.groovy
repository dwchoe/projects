package com.dwchoe.domain

import org.bson.types.ObjectId

class Stock {
    ObjectId id
    String name

    static constraints = {
    }

    static mapWith = "mongo"
}
