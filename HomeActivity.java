package INFO.TEXT.CODE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
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
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.EditText;
import de.hdodenhof.circleimageview.*;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.content.ClipData;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class HomeActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILE = 101;
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	
	private ArrayList<String> string = new ArrayList<>();
	
	private ScrollView vscroll3;
	private EditText edittext1;
	private LinearLayout _drawer_linear11;
	private ScrollView _drawer_vscroll2;
	private CircleImageView _drawer_circleimageview1;
	private TextView _drawer_textview2401;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private CardView _drawer_cardview1;
	private CardView _drawer_cardview2;
	private CardView _drawer_cardview3;
	private CardView _drawer_cardview4;
	private CardView _drawer_cardview5;
	private CardView _drawer_cardview11;
	private CardView _drawer_cardview6;
	private CardView _drawer_cardview8;
	private CardView _drawer_cardview10;
	private CardView _drawer_cardview7;
	private LinearLayout _drawer_linear12;
	private TextView _drawer_textview2412;
	private TextView _drawer_textview2402;
	private TextView _drawer_textview2403;
	private TextView _drawer_textview2404;
	private TextView _drawer_textview2405;
	private TextView _drawer_textview2406;
	private TextView _drawer_textview2407;
	private TextView _drawer_textview2408;
	private TextView _drawer_textview2409;
	private TextView _drawer_textview2410;
	private ImageView _drawer_imageview1;
	private TextView _drawer_textview2411;
	
	private Intent intan = new Intent();
	private Intent file = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder dialog;
	private TimerTask time;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
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
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		vscroll3 = findViewById(R.id.vscroll3);
		edittext1 = findViewById(R.id.edittext1);
		_drawer_linear11 = _nav_view.findViewById(R.id.linear11);
		_drawer_vscroll2 = _nav_view.findViewById(R.id.vscroll2);
		_drawer_circleimageview1 = _nav_view.findViewById(R.id.circleimageview1);
		_drawer_textview2401 = _nav_view.findViewById(R.id.textview2401);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_cardview1 = _nav_view.findViewById(R.id.cardview1);
		_drawer_cardview2 = _nav_view.findViewById(R.id.cardview2);
		_drawer_cardview3 = _nav_view.findViewById(R.id.cardview3);
		_drawer_cardview4 = _nav_view.findViewById(R.id.cardview4);
		_drawer_cardview5 = _nav_view.findViewById(R.id.cardview5);
		_drawer_cardview11 = _nav_view.findViewById(R.id.cardview11);
		_drawer_cardview6 = _nav_view.findViewById(R.id.cardview6);
		_drawer_cardview8 = _nav_view.findViewById(R.id.cardview8);
		_drawer_cardview10 = _nav_view.findViewById(R.id.cardview10);
		_drawer_cardview7 = _nav_view.findViewById(R.id.cardview7);
		_drawer_linear12 = _nav_view.findViewById(R.id.linear12);
		_drawer_textview2412 = _nav_view.findViewById(R.id.textview2412);
		_drawer_textview2402 = _nav_view.findViewById(R.id.textview2402);
		_drawer_textview2403 = _nav_view.findViewById(R.id.textview2403);
		_drawer_textview2404 = _nav_view.findViewById(R.id.textview2404);
		_drawer_textview2405 = _nav_view.findViewById(R.id.textview2405);
		_drawer_textview2406 = _nav_view.findViewById(R.id.textview2406);
		_drawer_textview2407 = _nav_view.findViewById(R.id.textview2407);
		_drawer_textview2408 = _nav_view.findViewById(R.id.textview2408);
		_drawer_textview2409 = _nav_view.findViewById(R.id.textview2409);
		_drawer_textview2410 = _nav_view.findViewById(R.id.textview2410);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_textview2411 = _nav_view.findViewById(R.id.textview2411);
		file.setType("text/*");
		file.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		dialog = new AlertDialog.Builder(this);
	}
	
	private void initializeLogic() {
		SimpleHighlighter syntx = new SimpleHighlighter(edittext1);
		//modified by kaviyarasan
		if (Build.VERSION.SDK_INT >= 21) { Window w = this.getWindow(); w.setNavigationBarColor(Color.parseColor("#000000")); }
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FILE:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				edittext1.setText(FileUtil.readFile(_filePath.get((int)(0))));
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 0, "Open New");
		menu.add(0, 2, 0, "Open file");
		menu.add(0, 3, 0, "Format ");
		SubMenu submenu1 = menu.addSubMenu("size");
		submenu1.add(0, 4, 0, "size 10");
		submenu1.add(0, 5, 0, "size 15");
		submenu1.add(0, 6, 0, "size 20");
		submenu1.add(0, 7, 0, "size 25");
		submenu1.add(0, 8, 0, "size 30");
		SubMenu submenu2 = menu.addSubMenu("Colour ");
		submenu2.add(0, 9, 0, "colour 15");
		submenu2.add(0, 10, 0, "colour 20");
		submenu2.add(0, 11, 0, "colour 25");
		submenu2.add(0, 12, 0, "colour 30");
		SubMenu submenu3 = menu.addSubMenu("background Colour ");
		submenu3.add(0, 13, 0, "bg colour 15");
		submenu3.add(0, 14, 0, "bg colour 20 ");
		submenu3.add(0, 15, 0, "bg colour 25");
		submenu3.add(0, 16, 0, "bg colour 30");
		SubMenu submenu4 = menu.addSubMenu("background paper ");
		submenu4.add(0, 17, 0, "Hacker 1");
		submenu4.add(0, 18, 0, "Hacker 2");
		submenu4.add(0, 19, 0, "Hacker 3");
		submenu4.add(0, 20, 0, "Hacker 4");
		MenuItem menuitem1 = menu.add(Menu.NONE, 21, Menu.NONE, "Save");
		menuitem1.setIcon(R.drawable.ic_file_download_white);
		menuitem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		MenuItem menuitem2 = menu.add(Menu.NONE, 22, Menu.NONE, "Run");
		menuitem2.setIcon(R.drawable.ic_send_white);
		menuitem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add(0, 23, 0, "source code");
		menu.add(0, 24, 0, "Exit");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final int _id = item.getItemId();
		final String _title = (String) item.getTitle();
		if (_id == 1) {
			SketchwareUtil.showMessage(getApplicationContext(), "open new");
			edittext1.setText("");
		}
		if (_id == 2) {
			SketchwareUtil.showMessage(getApplicationContext(), "open file");
			startActivityForResult(file, REQ_CD_FILE);
		}
		if (_id == 3) {
			SketchwareUtil.showMessage(getApplicationContext(), "Formate");
			edittext1.setText("<html>\n       <title>\n            Title\n       </title>\n <head>\n       <body>\n             ! Hello World\n       </body>\n  </head>\n</html>\n");
		}
		if (_id == 4) {
			edittext1.setTextSize((int)10);
		}
		if (_id == 5) {
			edittext1.setTextSize((int)15);
		}
		if (_id == 6) {
			edittext1.setTextSize((int)20);
		}
		if (_id == 7) {
			edittext1.setTextSize((int)25);
		}
		if (_id == 8) {
			edittext1.setTextSize((int)30);
		}
		if (_id == 9) {
			edittext1.setTextColor(0xFFB71C1C);
		}
		if (_id == 10) {
			edittext1.setTextColor(0xFF1B5E20);
		}
		if (_id == 11) {
			edittext1.setTextColor(0xFF448AFF);
		}
		if (_id == 12) {
			edittext1.setTextColor(0xFFFFAB00);
		}
		if (_id == 13) {
			vscroll3.setBackgroundColor(0xFF000000);
			edittext1.setBackgroundColor(0xFF000000);
			edittext1.setAlpha((float)(1.0d));
		}
		if (_id == 14) {
			vscroll3.setBackgroundColor(0xFF9E9E9E);
			edittext1.setBackgroundColor(0xFF9E9E9E);
			edittext1.setAlpha((float)(1.0d));
		}
		if (_id == 15) {
			edittext1.setBackgroundColor(0xFFFFFFFF);
			vscroll3.setBackgroundColor(0xFFFFFFFF);
			edittext1.setAlpha((float)(1.0d));
		}
		if (_id == 16) {
			vscroll3.setBackgroundColor(0xFF64B5F6);
			edittext1.setBackgroundColor(0xFF64B5F6);
			edittext1.setAlpha((float)(1.0d));
		}
		if (_id == 17) {
			vscroll3.setBackgroundResource(R.drawable.images_1);
			edittext1.setAlpha((float)(0.8d));
		}
		if (_id == 18) {
			vscroll3.setBackgroundResource(R.drawable.images_2);
			edittext1.setAlpha((float)(0.8d));
		}
		if (_id == 19) {
			vscroll3.setBackgroundResource(R.drawable.images_3);
			edittext1.setAlpha((float)(0.8d));
		}
		if (_id == 20) {
			vscroll3.setBackgroundResource(R.drawable.images_4);
			edittext1.setAlpha((float)(0.8d));
		}
		if (_id == 21) {
			SketchwareUtil.showMessage(getApplicationContext(), "Save");
			dialog.setTitle("SAVE");
			dialog.setMessage("save format ");
			dialog.setIcon(R.drawable.ic_thumb_up_black);
			final EditText edittext2= new EditText(HomeActivity.this); LinearLayout.LayoutParams Ipar = new
			
			LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
			
			LinearLayout.LayoutParams.WRAP_CONTENT);
			
			edittext2.setLayoutParams(Ipar
			
			); dialog.setView(edittext2);
			edittext2.setLines(1);
			dialog.setPositiveButton("save", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/html code/".concat(edittext2.getText().toString())), edittext1.getText().toString());
					SketchwareUtil.CustomToastWithIcon(getApplicationContext(), "YOUR FILE IS SAVED ", 0xFFFFFFFF, 15, 0xFF0D47A1, 10, SketchwareUtil.TOP, R.drawable.ic_thumb_up_black);
					edittext1.setText("");
				}
			});
			dialog.setNegativeButton("cancel ", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					SketchwareUtil.showMessage(getApplicationContext(), "cancel ");
				}
			});
			dialog.create().show();
		}
		if (_id == 22) {
			_loadingdailog(true, "Wait Your Page Is Loading ...");
			time = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							_loadingdailog(false, "");
						}
					});
				}
			};
			_timer.schedule(time, (int)(2000));
			intan.putExtra("data", edittext1.getText().toString());
			intan.setClass(getApplicationContext(), RunActivity.class);
			startActivity(intan);
			SketchwareUtil.showMessage(getApplicationContext(), "Run");
		}
		if (_id == 23) {
			intan.putExtra("pos", edittext1.getText().toString());
			intan.setClass(getApplicationContext(), ActionActivity.class);
			startActivity(intan);
		}
		if (_id == 24) {
			SketchwareUtil.showMessage(getApplicationContext(), "Exit");
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		dialog.setTitle("𝙒𝙖𝙧𝙣𝙞𝙣𝙜 ⚠️");
		dialog.setMessage("𝙰𝚛𝚎 𝚈𝚘𝚞 𝚂𝚞𝚛𝚎 𝙴𝚡𝚒𝚝 ?");
		dialog.setIcon(R.drawable.ic_backspace_grey);
		dialog.setNegativeButton("cancel ", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				SketchwareUtil.showMessage(getApplicationContext(), "𝘾𝙖𝙣𝙘𝙚𝙡  ");
			}
		});
		dialog.setPositiveButton("𝙀𝙭𝙞𝙩", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finish();
			}
		});
		dialog.create().show();
	}
	public void _loadingdailog(final boolean _ifShow, final String _title) {
		if (_ifShow) {
			if (prog == null){
				prog = new ProgressDialog(this);
				prog.setMax(100);
				prog.setIndeterminate(true);
				prog.setCancelable(false);
				prog.setCanceledOnTouchOutside(false);
			}
			prog.setMessage(_title);
			prog.show();
			//powered by kaviyarasan 
			
		}
		else {
			if (prog != null){
				prog.dismiss();
			}
			//powered by kaviyarasan 
			
		}
	} private ProgressDialog prog; {
		//powered by kaviyarasan 
		
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
