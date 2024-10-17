package vn.com.rangdong.fastscan.Util;

import android.util.Log;

import java.util.Arrays;

public class Converter {
    public static String convertToUUID(String input) {

        // Chuyển đổi chuỗi thành chuỗi UUID 8-4-4-12

        return input.substring(0, 8) +
                "-" +
                input.substring(8, 12) +
                "-" +
                input.substring(12, 16) +
                "-" +
                input.substring(16, 20) +
                "-" +
                input.substring(20);
    }

    public static String convertToHexString(String input) {
        return input.replace("-", "").toUpperCase();
    }

    public static byte[] intToByteArray(int num) {
        byte[] byteArray = new byte[2];
        byteArray[0] = (byte) ((num >> 8) & 0xFF);
        byteArray[1] = (byte) (num & 0xFF);
        return byteArray;
    }

    public static int byteArrayToInt(byte[] bytes) {
        // Đảm bảo mảng không rỗng
        if (bytes.length == 0) {
            throw new IllegalArgumentException("Mảng byte không được rỗng");
        }

        int result = 0;

        // Sử dụng phép toán bitwise để chuyển đổi byte thành int
        for (int i = 0; i < bytes.length; i++) {
            result |= (bytes[i] & 0xFF) << ((bytes.length - 1 - i) * 8);
        }

        return result;
    }

    public static byte[] convertToTwoBytes(int number) {
        byte[] result = new byte[2];
        // Lấy 2 chữ số đầu
        result[0] = (byte) ((number / 1000) & 0xFF);

        // Lấy 3 chữ số sau
        result[1] = (byte) (number % 1000 & 0xFF);
        return result;
    }

    public static int convertToThreeBytes(int number) {
        int A = number / 10000;
        int B = (number / 1000) % 10;
        int C = number % 1000;

        int byte1 = ((A & 0x0F) << 4) | (B & 0x0F);
        int rs = ((byte1 & 0xFF) <<8 )| (C & 0xFF);

        return rs;
    }

}
