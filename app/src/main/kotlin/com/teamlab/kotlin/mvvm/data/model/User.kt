package com.teamlab.kotlin.mvvm.data.model

import rx.mvvm.Model
import rx.property.RxPropertyObservable
import rx.property.value

class User(account: Account, user: twitter4j.User) : Model<Long>() {
    override val id = user.id
    val nameObservable = RxPropertyObservable.value("")
    var name by nameObservable.toProperty()
}
