package com.example.newcanalcollection.data.local.sharedPreference

import android.content.Context
import android.content.SharedPreferences
import com.example.newcanalcollection.data.models.User

class UserSharedPreference(var context: Context) {

    companion object {
        private lateinit var sharedPreferences: SharedPreferences
        private const val SHARED_PREFERENCE_NAME = "user"
        private const val TOKEN = "token"
        private const val USER_NAME = "receiver_name"
        private const val USER_PASSWORD = "receiver_password"
        private const val USER_FULL_NAME = "receiver_full_name"
        private const val USER_MOBILE = "receiver_mobile"
        private const val USER_CODE = "receiver_code"
        private const val IS_ACTIVE = "is_active"
        private const val MOBILE_SERIAL = "mobile_serial"
        private const val VERSION_NUMBER = "version_no"
        private const val COMPANY_CHAIRMAN = "CompanyChairman"
        private const val CLEAR_DATA_PASSWORD = "ClearDataPassword"
        private const val AUTO_SYNC = "auto_sync"
        private const val TIME_OUT = "timeout"


    }

    init {
        sharedPreferences =
            context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    /**
     * This method inserts the user to shared preference after login
     */
    fun insertUser(user: User) {
        with(sharedPreferences.edit()) {
            putString(TOKEN, user.token)
            putString(USER_NAME, user.userName)
            putString(USER_PASSWORD, user.password)
            putString(USER_FULL_NAME, user.userFullName)
            putString(USER_MOBILE, user.userMobile)
            putInt(USER_CODE, user.userCode)
            putBoolean(IS_ACTIVE, user.isActive)
            putString(MOBILE_SERIAL, user.mobileSerial)
            putFloat(VERSION_NUMBER, user.versionNo)
            putString(COMPANY_CHAIRMAN, user.companyChairman)
            putString(CLEAR_DATA_PASSWORD, user.clearDataPassword)
            putBoolean(AUTO_SYNC, user.autoSync)
            putLong(TIME_OUT, user.timeout)

            commit()
        }
    }


    /**
     * This method gets the user stored in shared preference
     */
    fun getUser(): User? {
        val token = sharedPreferences.getString(TOKEN, "") ?: ""
        val userName = sharedPreferences.getString(USER_NAME, "") ?: ""
        val password = sharedPreferences.getString(USER_PASSWORD, "") ?: ""
        val fullName = sharedPreferences.getString(USER_FULL_NAME, "") ?: ""
        val userMobile = sharedPreferences.getString(USER_MOBILE, "") ?: ""
        val userCode = sharedPreferences.getInt(USER_CODE, 0)
        val isActive = sharedPreferences.getBoolean(IS_ACTIVE, false)
        val mobileSerial = sharedPreferences.getString(MOBILE_SERIAL, "") ?: ""
        val versionNo = sharedPreferences.getFloat(VERSION_NUMBER, 0.0f)
        val companyChairman = sharedPreferences.getString(COMPANY_CHAIRMAN, "") ?: ""
        val clearDataPassword = sharedPreferences.getString(CLEAR_DATA_PASSWORD, "") ?: ""
        val autoSync = sharedPreferences.getBoolean(AUTO_SYNC, false)
        val timeout = sharedPreferences.getLong(TIME_OUT, 15)


        return if (token.isEmpty())
            null
        else
            User(
                token = token,
                userName = userName,
                password = password,
                userFullName = fullName,
                userMobile = userMobile,
                userCode = userCode,
                isActive = isActive,
                mobileSerial = mobileSerial,
                versionNo = versionNo,
                companyChairman = companyChairman,
                clearDataPassword = clearDataPassword,
                autoSync = autoSync,
                timeout = timeout
            )
    }

    /**
     * This method updates the user to shared preference after sync
     */
    fun updateUser(user: User) {
        with(sharedPreferences.edit()) {
            putString(USER_NAME, user.userName)
            putString(USER_FULL_NAME, user.userFullName)
            putString(USER_MOBILE, user.userMobile)
            putInt(USER_CODE, user.userCode)
            putBoolean(IS_ACTIVE, user.isActive)
            putString(MOBILE_SERIAL, user.mobileSerial)
            putFloat(VERSION_NUMBER, user.versionNo)
            putString(COMPANY_CHAIRMAN, user.companyChairman)
            putString(CLEAR_DATA_PASSWORD, user.clearDataPassword)
            putBoolean(AUTO_SYNC, user.autoSync)
            putLong(TIME_OUT, user.timeout)

            commit()
        }
    }

    /**
     * This method deletes the user from shared preference after logout
     */
    fun deleteUser() {
        with(sharedPreferences.edit()) {
            remove(TOKEN)
            remove(USER_NAME)
            remove(USER_PASSWORD)
            remove(USER_FULL_NAME)
            remove(USER_MOBILE)
            remove(USER_CODE)
            remove(IS_ACTIVE)
            remove(MOBILE_SERIAL)
            remove(VERSION_NUMBER)
            remove(COMPANY_CHAIRMAN)
            remove(CLEAR_DATA_PASSWORD)
            remove(AUTO_SYNC)
            remove(TIME_OUT)

            commit()
        }
    }
}