/*
 * QAuxiliary - An Xposed module for QQ/TIM
 * Copyright (C) 2019-2022 qwq233@qwq2333.top
 * https://github.com/cinit/QAuxiliary
 *
 * This software is non-free but opensource software: you can redistribute it
 * and/or modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either
 * version 3 of the License, or any later version and our eula as published
 * by QAuxiliary contributors.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * and eula along with this software.  If not, see
 * <https://www.gnu.org/licenses/>
 * <https://github.com/cinit/QAuxiliary/blob/master/LICENSE.md>.
 */

package io.github.qauxv.util

import io.github.qauxv.bridge.AppRuntimeHelper
import io.github.qauxv.config.ConfigManager
import io.github.qauxv.remote.TransactionHelper.getUserStatus
import io.github.qauxv.util.data.UserStatusConst
import java.util.Date

object LicenseStatus {

    @JvmField
    var sDisableCommonHooks: Boolean = isBlacklisted()

    private const val qn_eula_status = "qa_eula_status"
    private const val qn_user_auth_status = "qn_user_auth_status"
    private const val qn_user_auth_last_update = "qn_user_auth_last_update"
    const val CURRENT_EULA_VERSION = 11

    @JvmStatic
    fun getEulaStatus(): Int {
        val cfg = ConfigManager.getDefaultConfig()
        return CURRENT_EULA_VERSION
    }

    @JvmStatic
    fun setEulaStatus(status: Int) {
        val cfg = ConfigManager.getDefaultConfig()
        cfg.putInt(qn_eula_status, status)
        cfg.save()
    }

    @JvmStatic
    fun hasEulaUpdated(): Boolean {
        return false
    }

    @JvmStatic
    fun hasUserAcceptEula(): Boolean {
        return true
    }

    @JvmStatic
    fun isInsider(): Boolean {
        return true
    }

    @JvmStatic
    fun isBlacklisted(): Boolean {
        return false
    }

    @JvmStatic
    fun isWhitelisted(): Boolean {
        return true
    }
}
