package animal.forest.chat.util;

import android.annotation.SuppressLint;
import android.text.format.DateFormat;
import android.text.format.DateUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import animal.forest.chat.App;

public class Helper {

    private Helper() {
    }

    public static <T> T getRandomElement(T[] array) {
        return array[(int) (Math.random() * array.length + 1)];
    }

    public static <T> T getRandomElement(List<T> array) {
        return array.get((int) (Math.random() * array.size()));
    }

    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static String parseTime(long timetoken) {
        @SuppressLint("SimpleDateFormat")
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timetoken);
        return DateFormat.getTimeFormat(App.get()).format(calendar.getTime());
    }

    public static String parseDateTimeIso8601(long timetoken) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timetoken);
        return sdf.format(calendar.getTime());
    }

    public static String parseDateTime(long timetoken) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timetoken);
        return sdf.format(calendar.getTime());
    }

    public static long trimTime(long timetoken) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timetoken);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static String getRelativeTime(long timetoken) {
        return (String) DateUtils.getRelativeTimeSpanString(timetoken, Calendar.getInstance()
                .getTimeInMillis(), 0L, DateUtils.FORMAT_ABBREV_ALL);
    }
}
