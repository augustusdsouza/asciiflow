package com.lewish.asciiflow.client.tools;

import com.lewish.asciiflow.client.Canvas;
import com.lewish.asciiflow.client.HistoryManager;
import com.lewish.asciiflow.client.common.Box;
import com.lewish.asciiflow.client.resources.AsciiflowClientBundle;

public abstract class BaseBoxTool extends DragTool {

	public BaseBoxTool(Canvas canvas, HistoryManager historyManager,
			AsciiflowClientBundle clientBundle) {
		super(canvas, historyManager, clientBundle);
	}

	@Override
	protected abstract void draw(Box box);

	public static void draw(Box box, Canvas canvas, boolean titled) {
		int x1 = box.topLeftX();
		int y1 = box.topLeftY();
		int x2 = box.bottomRightX();
		int y2 = box.bottomRightY();

		canvas.draw(x1, y1, "+");
		canvas.draw(x1, y2, "+");
		canvas.draw(x2, y1, "+");
		canvas.draw(x2, y2, "+");

		boolean showTitle = titled && (y2 - y1) > 2;

		for (int x = x1 + 1; x < x2; x++) {
			canvas.draw(x, y1, "-");
			canvas.draw(x, y2, "-");
			if (showTitle) {
				canvas.draw(x, y1 + 2, "-");
			}
		}
		for (int y = y1 + 1; y < y2; y++) {
			canvas.draw(x1, y, "|");
			canvas.draw(x2, y, "|");
		}
	}
}
