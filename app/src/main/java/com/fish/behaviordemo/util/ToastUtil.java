package com.fish.behaviordemo.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

	private static Toast mToast;

	public static void showToast(Context ctx, String msg) {
		if (ctx == null) {
			return;
		}

		if (mToast == null) {
			mToast = Toast.makeText(ctx.getApplicationContext(), msg, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(msg);
		}
		mToast.show();
	}

	public static void releaseToast() {
		if (mToast != null) {
			mToast.cancel();
			mToast = null;
		}
	}

}
