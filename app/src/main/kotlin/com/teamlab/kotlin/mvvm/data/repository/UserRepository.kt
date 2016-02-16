package com.teamlab.kotlin.mvvm.data.repository

import com.teamlab.kotlin.mvvm.data.model.Account
import com.teamlab.kotlin.mvvm.data.model.User
import com.teamlab.kotlin.mvvm.di.AccountScope
import rx.mvvm.Cache
import javax.inject.Inject

@AccountScope
class UserRepository @Inject constructor(private val account: Account) {

    private val cache = Cache<User, Long>()

    fun of(user: twitter4j.User): User {
        return cache.getOrPut(user.id, { User(account, user) })
    }
}