package com.EvanMao.Tool;

import android.os.AsyncTask;

public abstract class UIDoAsyncTaskOnBackground extends
		AsyncTask<Object, Object, Object> {

	@Override
	protected Object doInBackground(Object... params) {
		// TODO Auto-generated method stub		
		return doTask(params);
	}

	public abstract Object doTask(Object... params);

	@Override
	protected void onProgressUpdate (Object... values)
	{
		doProgressUpdate(values);
	}

	public abstract void doProgressUpdate(Object... values);

	@Override
	protected void onCancelled ()
	{
		super.onCancelled();
		//
		doBeforeCanceled();
	}

	public abstract void doBeforeCanceled();

	@Override
	protected void onPostExecute(Object result)
	{
		super.onPostExecute(result);
		//
		doAfterTask(result);
	}

	public abstract void doAfterTask(Object result);

	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
		//
		doBeforeTask();
	}

	public abstract void doBeforeTask();

}
