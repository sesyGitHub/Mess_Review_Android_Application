package com.example.utkarsh.mess.app;

import android.provider.BaseColumns;

/**
 * Created by Utkarsh on 04-Aug-15.
 */
public class Contract {

    public static abstract class MainTable implements BaseColumns {
        public static final String TABLE_NAME = "Mess_menu";

        public static final String COLUMN_NAME_BREAKFAST_key = "BreakfastEntry";
        public static final String COLUMN_NAME_LUNCH_key = "Lunch";
        public static final String COLUMN_NAME_Dinner_key = "Dinner";

    }

    public static abstract class BreakfastTable implements BaseColumns {
        public static final String TABLE_NAME = "BreakfastEntry";

    }

    public static abstract class LunchTable implements BaseColumns {
        public static final String TABLE_NAME = "Lunch";

    }

    public static abstract class DinnerTable implements BaseColumns {
        public static final String TABLE_NAME = "Dinner";

    }
}
