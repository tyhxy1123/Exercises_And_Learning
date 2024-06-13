package com.service.impl

import com.service.IAccountService

class AccountServiceImpl:IAccountService {
    override fun savaAccount() {
        println("保存账户")
    }

    override fun updateAccount(i: Int) {
        println("更新账户 $i")
    }

    override fun deleteAccount(): Int {
        println("删除账户")
        return 1
    }
}