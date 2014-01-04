package fr.efrei.babylon.part_y;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DashAdaptater extends BaseAdapter {

	List<Dashboard> dashboards;
	LayoutInflater inflater;
	
	public DashAdaptater(Context context, List<Dashboard> dash){
		inflater = LayoutInflater.from(context);
		this.dashboards = dash;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dashboards.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return dashboards.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	private class ViewHolder {
		TextView tvTitre;
		TextView tvDescription;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;

		if(convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.itemdashborad, null);

			holder.tvTitre = (TextView)convertView.findViewById(R.id.Titre);
			holder.tvDescription = (TextView)convertView.findViewById(R.id.Description);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.tvTitre.setText(dashboards.get(position).getTitre());
		holder.tvDescription.setText(dashboards.get(position).getDescription());
		

		return convertView;
	}
	


}
