package in.cycorax.listviewmenudemo;

import in.cycorax.listviewmenudemo.ws.InvokeWebService;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] listOfCountries = new String[] { "India", "Sweden",
			"Spain", "South Africa", "Singapore" };
	private ListView listOfCountryView;
	private final static String OPTION_ONE = "Option 1";
	private final static String OPTION_TWO = "Option 2";

	private ArrayAdapter simpleAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listOfCountryView = (ListView) findViewById(R.id.list_of_countries);

		if (listOfCountries != null) {
			simpleAdapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, listOfCountries);
			listOfCountryView.setAdapter(simpleAdapter);
			registerForContextMenu(listOfCountryView);
		}
		ImageButton button = (ImageButton) findViewById(R.id.button1);
		listOfCountryView.setEmptyView(button);
	//	InvokeWebService.invokeHelloWorldWS();

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		if (item.getTitle().equals(OPTION_ONE)) {
			Toast.makeText(this, "Option One Pressed.", Toast.LENGTH_LONG)
					.show();

		}
		if (item.getTitle().equals(OPTION_TWO)) {
			Toast.makeText(this, "Option Two Pressed.", Toast.LENGTH_LONG)
					.show();

		}
		return super.onContextItemSelected(item);

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("List of Options");
		menu.add(0, v.getId(), 0, OPTION_ONE);
		menu.add(0, v.getId(), 0, OPTION_TWO);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);

	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
