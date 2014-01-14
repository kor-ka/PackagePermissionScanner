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
TextView tv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView) findViewById(R.id.tv);
	List<ApplicationInfo> packages = getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
		
	for(ApplicationInfo packageInfo : packages){
		String packageName = packageInfo.packageName;
	//	tv.setText(tv.getText().toString() + "\n" +  "\n" +" |//////// " + packageName+ " ////////| ");
		try
		{
			PackageInfo pkgInfo = getPackageManager().getPackageInfo(
				packageInfo.packageName, 
				PackageManager.GET_PERMISSIONS
			);
			PermissionInfo[] permissions = pkgInfo.permissions;
			if (permissions != null){
		for (PermissionInfo permission : permissions){
			
				String permissionStr = permission.toString();
				if (permissionStr.contains("RECEIVE_SMS")){
					tv.setText(tv.getText().toString() + "\n" +  "\n" +packageName);	
				}
			//	tv.setText(tv.getText().toString() + "\n" + permissionStr);
//			Toast.makeText(this, "null.", Toast.LENGTH_SHORT).show();
				}
			}
			
		}
		catch (PackageManager.NameNotFoundException e)
		{}
		
	}
    }
}
