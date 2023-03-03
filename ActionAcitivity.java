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
import android.widget.ScrollView;
import br.tiagohm.codeview.CodeView;
import br.tiagohm.codeview.Theme;
import br.tiagohm.codeview.Language;
import br.tiagohm.codeview.CodeView.OnHighlightListener;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class ActionActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private ScrollView vscroll1;
	private CodeView codeview1;
	
	private Intent in = new Intent();
	private AlertDialog.Builder d;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.action);
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
		vscroll1 = findViewById(R.id.vscroll1);
		codeview1 = findViewById(R.id.codeview1);
		d = new AlertDialog.Builder(this);
	}
	
	private void initializeLogic() {
		//modified by kaviyarasan
		if (Build.VERSION.SDK_INT >= 21) { Window w = this.getWindow(); w.setNavigationBarColor(Color.parseColor("#000000")); }
		codeview1.setCode(getIntent().getStringExtra("pos"));
		codeview1.setLanguage(Language.HTML);
		codeview1.setTheme(Theme.GITHUB );
		codeview1.apply();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem menuitem1 = menu.add(Menu.NONE, 1, Menu.NONE, "add source ");
		menuitem1.setIcon(R.drawable.ic_add_circle_white);
		menuitem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		SubMenu submenu1 = menu.addSubMenu("LANGUAGE ");
		submenu1.add(0, 2, 0, "HTML");
		submenu1.add(0, 3, 0, "JAVA");
		submenu1.add(0, 4, 0, "CSS");
		submenu1.add(0, 5, 0, "PYTHON ");
		submenu1.add(0, 6, 0, "php");
		SubMenu submenu2 = menu.addSubMenu("THEME ");
		submenu2.add(0, 7, 0, "GITHUB ");
		submenu2.add(0, 8, 0, "ANDROID STUDIO ");
		submenu2.add(0, 9, 0, "VS CODE");
		submenu2.add(0, 10, 0, "RAINBOW ");
		SubMenu submenu3 = menu.addSubMenu("CODE FORMAT ");
		submenu3.add(0, 11, 0, "Normal");
		submenu3.add(0, 12, 0, "Script ");
		submenu3.add(0, 13, 0, "Table ");
		submenu3.add(0, 14, 0, "Text");
		menu.add(0, 15, 0, "Exit");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final int _id = item.getItemId();
		final String _title = (String) item.getTitle();
		if (_id == 1) {
			final EditText edittext2= new EditText(ActionActivity.this); LinearLayout.LayoutParams Ipar = new 
			
			LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
			
			LinearLayout.LayoutParams.WRAP_CONTENT);
			
			edittext2.setLayoutParams(Ipar
			
			); d.setView(edittext2);
			edittext2.setLines(10);
			d.setTitle("Add Your Source Code ");
			d.setMessage("Add Your Source Code Directly Copy Past Here ▪️");
			d.setIcon(R.drawable.ic_public_black);
			d.setPositiveButton("Add Your Code ", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					codeview1.setCode(edittext2.getText().toString());
					codeview1.apply();
					SketchwareUtil.CustomToastWithIcon(getApplicationContext(), "Your Code Is Ready", 0xFFFFFFFF, 15, 0xFF0D47A1, 10, SketchwareUtil.TOP, R.drawable.ic_vertical_align_center_white);
				}
			});
			d.setNegativeButton("cancel ", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					SketchwareUtil.showMessage(getApplicationContext(), "cancel ");
				}
			});
			d.create().show();
		}
		if (_id == 2) {
			codeview1.setLanguage(Language.HTML);
			codeview1.apply();
		}
		if (_id == 3) {
			codeview1.setLanguage(Language.JAVA);
			codeview1.apply();
		}
		if (_id == 4) {
			codeview1.setLanguage(Language.CSS);
			codeview1.apply();
		}
		if (_id == 5) {
			codeview1.setLanguage(Language.PYTHON);
			codeview1.apply();
		}
		if (_id == 6) {
			codeview1.setLanguage(Language.PHP);
			codeview1.apply();
		}
		if (_id == 7) {
			vscroll1.setBackgroundColor(Color.TRANSPARENT);
			codeview1.setTheme(Theme.GITHUB );
			codeview1.apply();
		}
		if (_id == 8) {
			vscroll1.setBackgroundColor(0xFF263238);
			codeview1.setTheme(Theme.ANDROIDSTUDIO );
			codeview1.apply();
		}
		if (_id == 9) {
			vscroll1.setBackgroundColor(0xFFFFFFFF);
			codeview1.setTheme(Theme.VS );
			codeview1.apply();
		}
		if (_id == 10) {
			vscroll1.setBackgroundColor(0xFF424242);
			codeview1.setTheme(Theme.RAINBOW );
			codeview1.apply();
		}
		if (_id == 11) {
			codeview1.setCode("<html>\n       <title>\n            Title\n       </title>\n <head>\n       <body>\n             ! Hello World\n       </body>\n  </head>\n</html>\n");
			codeview1.apply();
		}
		if (_id == 12) {
			codeview1.setCode("<!DOCTYPE html>\n<html>\n<head>\n   <title> Try It Yourself </title>\n</head>\n<body>\n   <script type=\"text/javascript\">\n       alert(\"Hi I'm an alert box.\");  \n   </script>\n</body>\n</html>");
			codeview1.apply();
		}
		if (_id == 13) {
			codeview1.setCode("<!DOCTYPE html>\n<html>\n<head>\n   <title> Try It Yourself </title>\n</head>\n<body>\n   <table>\n      <thead>\n         <tr>\n            <th> First Name </th>\n            <th> Last Name </th>\n         </tr>\n      </thead>\n      <tbody>\n         <tr>\n            <td> Juan </td>\n            <td> Dela Cruz </td>\n         </tr>\n      </tbody>\n      <tfoot>\n         <tr>\n            <td> Footer </td>\n            <td> Footer </td>\n         </tr>\n      </tfoot>\n   </table>\n</body>\n</html>");
			codeview1.apply();
		}
		if (_id == 14) {
			codeview1.setCode("<!DOCTYPE html>\n<html>\n<head>\n   <title> Try It Yourself </title>\n</head>\n<body>\n   <!-- bold -->\n   <b>I am a bolded text.</b>\n   <br />\n   <!-- italic -->\n   <i>I am an italic text</i>\n   <br />\n   <!-- underlined -->\n   <u>I am an underlined text.</u>\n   <br />\n   <!-- code -->\n   <code>I am a code text.</code>\n   <br />\n   <!-- typewriter text -->\n   <tt>I am a typewriter text.</tt>\n   <br />\n   <!-- small text -->\n   <small>I am a small text.</small>\n   <br />\n   <!-- emphasized text -->\n   <em>I am a an emphasized text.</em>\n   <br />\n   <!-- strong text -->\n   <strong>I am a strong text.</strong>\n   <br />\n   <!-- marked text -->\n   <mark>I am a marked text.</mark>\n   <br />\n   <!-- quoted text -->\n   <q>I am an enquoted text.</q>\n   <br />\n   <!-- striked text -->\n   <s>I am a striked text.</s>\n   <br />\n   <!-- mixed formatted -->\n   <b><i><u><mark><q> I am a mixed formatted text. </q></mark></u></i></b>\n</body>\n</html>");
			codeview1.apply();
		}
		if (_id == 15) {
			finish();
		}
		return super.onOptionsItemSelected(item);
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
