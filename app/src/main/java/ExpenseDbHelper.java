import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kyle on 9/20/2015.
 */
public class ExpenseDbHelper extends SQLiteOpenHelper {

    public static String TAG = ExpenseDbHelper.class.getSimpleName();
    private static final int DB_VERSION = 6;
    public static final String DB_NAME = "MoneyManagement";

    //////////////////////////////////////// Expenses Class ////////////////////////////////////////
    public static final String EXPENSE_TABLE_NAME = "expensesDb";
    public static final String[] EXPENSE_FIELDS = {"expenses", "date"};

    private static final String EXPENSE_TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + EXPENSE_TABLE_NAME + " (" +
                    EXPENSE_FIELDS[0] + " INTEGER NOT NULL, " +
                    EXPENSE_FIELDS[1] + " datetime NOT NULL, ";

    public static final String EXPENSE_SELECT_ALL = "SELECT * FROM " + EXPENSE_TABLE_NAME;
    public static String expenseSelectById( int expenseId ){

        return "SELECT * FROM " + EXPENSE_TABLE_NAME + " WHERE id='" + expenseId + "'";

    }

    ExpenseDbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db){

        db.execSQL(EXPENSE_TABLE_CREATE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


    }

}
