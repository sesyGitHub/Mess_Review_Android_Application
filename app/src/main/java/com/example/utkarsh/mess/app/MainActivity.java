package com.example.utkarsh.mess.app;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Utkarsh on 13-Aug-15.
 */
public class MainActivity {
    public class MainActivity extends FragmentActivity {
        ...
        // Constants
        // Content provider authority
        public static final String AUTHORITY = "com.example.android.datasync.provider";
        // Account
        public static final String ACCOUNT = "default_account";
        // Global variables
        // A content resolver for accessing the provider
        ContentResolver mResolver;
        ...
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ...
            // Get the content resolver for your app
            mResolver = getContentResolver();
            // Turn on automatic syncing for the default account and authority
            mResolver.setSyncAutomatically(ACCOUNT, AUTHORITY, true);
            ...
        }
        ...
    }
    public class MainActivity extends FragmentActivity {
        ...
        // Constants
        // Content provider scheme
        public static final String SCHEME = "content://";
        // Content provider authority
        public static final String AUTHORITY = "com.example.android.datasync.provider";
        // Path for the content provider table
        public static final String TABLE_PATH = "data_table";
        // Account
        public static final String ACCOUNT = "default_account";
        // Global variables
        // A content URI for the content provider's data table
        Uri mUri;
        // A content resolver for accessing the provider
        ContentResolver mResolver;
        ...
        public class TableObserver extends ContentObserver {
            /*
             * Define a method that's called when data in the
             * observed content provider changes.
             * This method signature is provided for compatibility with
             * older platforms.
             */
            @Override
            public void onChange(boolean selfChange) {
            /*
             * Invoke the method signature available as of
             * Android platform version 4.1, with a null URI.
             */
                onChange(selfChange, null);
            }
            /*
             * Define a method that's called when data in the
             * observed content provider changes.
             */
            @Override
            public void onChange(boolean selfChange, Uri changeUri) {
            /*
             * Ask the framework to run your sync adapter.
             * To maintain backward compatibility, assume that
             * changeUri is null.
            ContentResolver.requestSync(ACCOUNT, AUTHORITY, null);
        }
        ...
    }
    ...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...
        // Get the content resolver object for your app
        mResolver = getContentResolver();
        // Construct a URI that points to the content provider data table
        mUri = new Uri.Builder()
                  .scheme(SCHEME)
                  .authority(AUTHORITY)
                  .path(TABLE_PATH)
                  .build();
        /*
         * Create a content observer object.
         * Its code does not mutate the provider, so set
         * selfChange to "false"
         */
                TableObserver observer = new TableObserver(false);
        /*
         * Register the observer for the data table. The table's path
         * and any of its subpaths trigger the observer.
         */
                mResolver.registerContentObserver(mUri, true, observer);
                ...
            }
            ...
        }
}
