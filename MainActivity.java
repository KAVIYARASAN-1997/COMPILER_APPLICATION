package INFO.TEXT.CODE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.CheckBox;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private LinearLayout linear1;
	private TextView textview4;
	private TextView textview3;
	private CheckBox checkbox1;
	private CardView cardview1;
	private TextView textview1;
	
	private Intent inta = new Intent();
	private SharedPreferences share;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private AlertDialog.Builder dialog;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear1 = findViewById(R.id.linear1);
		textview4 = findViewById(R.id.textview4);
		textview3 = findViewById(R.id.textview3);
		checkbox1 = findViewById(R.id.checkbox1);
		cardview1 = findViewById(R.id.cardview1);
		textview1 = findViewById(R.id.textview1);
		share = getSharedPreferences("share", Activity.MODE_PRIVATE);
		net = new RequestNetwork(this);
		dialog = new AlertDialog.Builder(this);
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (true) {
					checkbox1.setChecked(true);
					textview1.setVisibility(View.VISIBLE);
					cardview1.setVisibility(View.VISIBLE);
				}
				else {
					checkbox1.setChecked(false);
					textview1.setVisibility(View.GONE);
					cardview1.setVisibility(View.GONE);
				}
				SketchwareUtil.CustomToast(getApplicationContext(), "𝑇ℎ𝑎𝑛𝑘 𝑌𝑜𝑢 𝐹𝑜𝑟 𝐴𝑐𝑐𝑒𝑝𝑡𝑖𝑛𝑔 ", 0xFFFFFFFF, 20, 0xFF0D47A1, 5, SketchwareUtil.CENTER);
				SketchwareUtil.CustomToastWithIcon(getApplicationContext(), "𝙲𝚛𝚎𝚊𝚝𝚎𝚍 𝙱𝚢:  𝐾𝐴𝑉𝐼𝑌𝐴𝑅𝐴𝑆𝐴𝑁 ", 0xFFFFFFFF, 15, 0xFF0D47A1, 5, SketchwareUtil.CENTER, R.drawable.ic_public_black);
			}
		});
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				inta.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(inta);
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				dialog.setTitle("System Notification ");
				dialog.setMessage("No Internet Connection Please Check Your Connection 🥺");
				dialog.setIcon(R.drawable.ic_signal_wifi_statusbar_not_connected_grey);
				dialog.setPositiveButton("Retry ", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						net.startRequestNetwork(RequestNetworkController.GET, "https://github.com/kaviyarasan-1997", "A", _net_request_listener);
					}
				});
				dialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finish();
					}
				});
				dialog.setCancelable(false);
				dialog.create().show();
			}
		};
	}
	
	private void initializeLogic() {
		cardview1.setVisibility(View.GONE);
		textview1.setVisibility(View.GONE);
		if (!share.getString("view", "").contains("ok")) {
			share.edit().putString("view", "ok").commit();
		}
		else {
			inta.setClass(getApplicationContext(), HomeActivity.class);
			startActivity(inta);
			finish();
		}
		net.startRequestNetwork(RequestNetworkController.GET, "https://github.com/kaviyarasan-1997", "A", _net_request_listener);
		//modified by kaviyarasan
		if (Build.VERSION.SDK_INT >= 21) { Window w = this.getWindow(); w.setNavigationBarColor(Color.parseColor("#000000")); }
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
