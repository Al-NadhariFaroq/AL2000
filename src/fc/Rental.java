package fc;

import java.util.Calendar;
import java.util.Date;

public class Rental {
    Date rentalDate;
    Date rentalReturn;
    Support support;

    public Rental(Support s){
        support = s;
        rentalDate = Calendar.getInstance().getTime();
    }

    public Support getSupport(){
        return support;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getRentalReturn() {
        return rentalReturn;
    }

    public void setRentalReturn(Date rentalReturn) {
        this.rentalReturn = rentalReturn;
    }
}
