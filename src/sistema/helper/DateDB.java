package sistema.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDB {
    private Date date;

    public DateDB() {
        this.date = new Date();
    }

    public String getDate() throws ParseException {
        String createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.date);
        return createdDate;
    }
}
