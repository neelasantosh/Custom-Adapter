package com.example.customadapter1;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	ListView listViewBooks;
	ArrayList<Book> listBooks = new ArrayList<Book>();
	BookAdapter adapter;
	Button buttonCount;
	CheckBox checkbox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		buttonCount = (Button) findViewById(R.id.buttonCount);
		listViewBooks = (ListView) findViewById(R.id.listView1);
		checkbox=(CheckBox) findViewById(R.id.checkboxSelected);
		
		buttonCount.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
			int count=0;
			for(Book b : listBooks)
			{
				if(b.isSelected())
				{
					count++;
				}
			}	
			Toast.makeText(HomeActivity.this, "Selected:" + count, Toast.LENGTH_LONG).show();
		}
		});
		
		
	
		
		// Book b1=new Book(title, author, price, selected); add book items
		Book b1 = new Book("Wings of Fire", "A.P.J. Abdul Kalam", 250, true);
		Book b2 = new Book("Android", "Rick", 550, true);
		Book b3 = new Book("Abc", "chethan bhagath", 750, true);

		listBooks.add(b1);
		listBooks.add(b2);
		listBooks.add(b3);

		// intialize adapter

		adapter = new BookAdapter();

		listViewBooks.setAdapter(adapter);

	}// eof oncreate

	class BookAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listBooks.size();
		}

		@Override
		public Book getItem(int position) {
			// TODO Auto-generated method stub
			return listBooks.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		// executes for each position at a item(if 4 items it executes 4 times)
		@Override
		public View getView(final int position, View convertView, ViewGroup arg2) {
			// TODO Auto-generated method stub

			// load UI for Item
			LayoutInflater inflater = getLayoutInflater();// this class converts
															// .xml to UI type
															// object containg
															// complete view
			View itemView = inflater.inflate(R.layout.item_view, null);

			// fill itemview with book object data

			Book book = listBooks.get(position);

			// to get item from itemview

			TextView textTitle = (TextView) itemView
					.findViewById(R.id.textViewTitle);
			textTitle.setText(book.getTitle());

			TextView textAuthor = (TextView) itemView
					.findViewById(R.id.textViewAuthor);
			textAuthor.setText(book.getAuthor());

			TextView textPrice = (TextView) itemView
					.findViewById(R.id.textPrice);
			textPrice.setText(book.getPrice() + "");

			CheckBox checkIsSelected = (CheckBox) itemView
					.findViewById(R.id.checkboxSelected);
			checkIsSelected.setChecked(book.isSelected());

			Button buttonDelete = (Button) itemView
					.findViewById(R.id.buttonDelete);
			buttonDelete.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					listBooks.remove(position);
					notifyDataSetChanged();
				}
			});
			
			checkIsSelected.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
				Book b	= listBooks.get(position);
				b.setSelected(isChecked);
					
			
				}
			});

			return itemView;
		}

	}

}// eof activity
