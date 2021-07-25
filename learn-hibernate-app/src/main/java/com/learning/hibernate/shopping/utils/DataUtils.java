package com.learning.hibernate.shopping.utils;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class DataUtils {

	public static PhoneNumber parsePhoneNumber(String phoneNum) {
        if (phoneNum == null) {
            return null;
        }
        try {
            return PhoneNumberUtil.getInstance().parse(phoneNum, "US");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatPhoneNumber(PhoneNumber phoneNum) {
        if (phoneNum == null) {
            return null;
        }
        return PhoneNumberUtil.getInstance().format(phoneNum, PhoneNumberFormat.E164);
    }
}
