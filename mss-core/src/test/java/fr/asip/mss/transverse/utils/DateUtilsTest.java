package fr.asip.mss.transverse.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Classe de test de DateUtils.
 * 
 */
public class DateUtilsTest {
    @Test
    public void testTimestampToDate() {
        long time = 454337985;
        Timestamp timestamp = new Timestamp(time);
        Date res = DateUtils.timestampToDate(timestamp);
        Assert.assertNotNull(res);
        Assert.assertEquals(time, res.getTime());

        res = DateUtils.timestampToDate(null);
        Assert.assertNull(res);
    }

    @Test
    public void testDateToString() {

        String res = DateUtils.dateToString(null, DateUtils.FORMAT_JJMMAAAA);
        Assert.assertNull(res);

        res = DateUtils.dateToString(new Date(), null);
        Assert.assertNull(res);

        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.DATE, 12);
        cal.set(Calendar.YEAR, 2013);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        res = DateUtils.dateToString(cal.getTime(), DateUtils.FORMAT_JJMMAAAA);
        Assert.assertNotNull(res);
        Assert.assertEquals("12/10/2013", res);
    }

    @Test
    public void testStringToDate() throws ParseException {

        Date res = DateUtils.stringToDate(null, DateUtils.FORMAT_JJMMAAAA);
        Assert.assertNull(res);

        res = DateUtils.stringToDate("12/10/2013", null);
        Assert.assertNull(res);

        res = DateUtils.stringToDate("12/10/2013", DateUtils.FORMAT_JJMMAAAA);
        Assert.assertNotNull(res);
        Calendar cal = new GregorianCalendar();
        cal.setTime(res);
        Assert.assertEquals(12, cal.get(Calendar.DATE));
        Assert.assertEquals(Calendar.OCTOBER, cal.get(Calendar.MONTH));
        Assert.assertEquals(2013, cal.get(Calendar.YEAR));

    }

    @Test
    public void testDateToZimbraRelative() throws ParseException {

        String res = DateUtils.dateToZimbraRelative(null);
        Assert.assertNull(res);

    }

}
