package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.pm.*;
import java.util.*;
import android.content.pm.PackageManager.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	List<ApplicationInfo> packages =	getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
		
	for(ApplicationInfo packageInfo : packages){
		String packageName = packageInfo.packageName;
		
		try
		{
			PackageInfo pkgInfo = getPackageManager().getPackageInfo(
				packageName, 
				PackageManager.GET_PERMISSIONS
			);
			PermissionInfo[] permissions = pkgInfo.permissions;
			for (PermissionInfo permission : permissions){
				permission.toString();
			}
		}
		catch (PackageManager.NameNotFoundException e)
		{}
		
	}
    }
}
