package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.renderers.GWTRenderObject;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer.WebGLCanvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public abstract class AbstractDemoEntryPoint implements EntryPoint {

	private WebGLRenderer renderer;



	protected Timer timer;
	protected Stats stats;



	protected WebGLCanvas canvas;



	private PopupPanel dialog;



	private Button hide;



	private VerticalPanel main;
	
	protected int canvasWidth,canvasHeight;
	public WebGLCanvas getCanvas() {
		return canvas;
	}
	public abstract void onMouseClick(ClickEvent event);
	public abstract void onMouseWheel(MouseWheelEvent event);
	public abstract void onMouseMove(MouseMoveEvent event) ;
	public abstract void onMouseDown(MouseDownEvent event) ;
	public abstract void onMouseUp(MouseUpEvent event) ;
	public abstract void onMouseOut(MouseOutEvent event);
	public abstract void update(WebGLRenderer renderer);
	public abstract void initialize(WebGLRenderer renderer,int width,int height);
	public abstract void resized(int width,int height);
	public void onModuleLoad() {
		int width=Window.getClientWidth();
		int height=Window.getClientHeight();
		/**
		 * 
		 * if
			com.google.gwt.core.client.JavaScriptException: (TypeError): Cannot read property 'WebGLRenderer' of undefined
			
			add lines and both js files on same directory with html
			<script type="text/javascript" language="javascript" src="Three.js"></script>
    		<script type="text/javascript" language="javascript" src="stats.js"></script>     
		 */
		renderer = THREE.WebGLRenderer(GWTRenderObject.create().preserveDrawingBuffer());
		renderer.setSize(width,height);
		
		
		//renderer.setClearColorHex(0x333333, 1);
		
		//RootLayoutPanel.get().setStyleName("transparent");
		
		canvas = new WebGLCanvas(renderer);
		canvas.setClearColorHex(0);
		//final FocusPanel glCanvas=new FocusPanel(canvas);
		
		canvas.addMouseUpHandler(new MouseUpHandler() {
			
			@Override
			public void onMouseUp(MouseUpEvent event) {
			
				AbstractDemoEntryPoint.this.onMouseUp(event);
			}
		});


		canvas.addMouseWheelHandler(new MouseWheelHandler() {
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				AbstractDemoEntryPoint.this.onMouseWheel(event);
			}
		});
		//hpanel.setFocus(true);
		
		
		canvas.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AbstractDemoEntryPoint.this.onMouseClick(event);
			}
		});
		
		canvas.addMouseDownHandler(new MouseDownHandler() {
			
			@Override
			public void onMouseDown(MouseDownEvent event) {
				AbstractDemoEntryPoint.this.onMouseDown(event);
				
			}
		});
		
		canvas.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				AbstractDemoEntryPoint.this.onMouseOut(event);
			}
		});
		
		canvas.addMouseMoveHandler(new MouseMoveHandler(){

			@Override
			public void onMouseMove(MouseMoveEvent event) {
				AbstractDemoEntryPoint.this.onMouseMove(event);
			}});
		
		//canvas.setStyleName("clear");
		//glCanvas.getElement().getStyle().setBackgroundColor("#fff");
		canvas.setWidth("100%");
		canvas.setHeight("100%");
		RootLayoutPanel.get().add(canvas);
		
		canvasWidth=width;
		canvasHeight=height;
		initialize(renderer,width,height);
		
		stats = Stats.insertStatsToRootPanel();
		timer = new Timer(){
			public void run(){
				update(renderer);
				stats.update();
			}
		};
		
		
		
		if(!GWT.isScript()){
			timer.scheduleRepeating(100);
		}else{
			timer.scheduleRepeating(1000/60);
		}
		
		
		
		dialog = new PopupPanel();
		VerticalPanel dialogRoot=new VerticalPanel();
		dialogRoot.setSpacing(2);
		//dialog.setStyleName("transparent");
		Label label=new Label("Control");
		label.setStyleName("title");
		dialog.add(dialogRoot);
		dialogRoot.add(label);
		main = new VerticalPanel();
		main.setVisible(false);
		
		
		HorizontalPanel hPanel=new HorizontalPanel();
		hPanel.setWidth("100%");
		hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);
		dialogRoot.add(hPanel);
		hide = new Button("Hide Control");
		
		hide.setVisible(false);
		hide.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				main.setVisible(false);
				hide.setVisible(false);
				rightTop(dialog);
			}
		});
		hPanel.add(hide);
		
		dialogRoot.add(main);
		
		label.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				showControl();
			}
		});
		
		createControl(main);
		
		dialog.show();
		rightTop(dialog);
		
		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				int w=canvas.getOffsetWidth();
				int h=canvas.getOffsetHeight();
				canvasWidth=w;
				canvasHeight=h;
				resized(w,h);
				renderer.setSize(w, h);
				rightTop(dialog);
			}
		});
		HorizontalPanel vpanel=new HorizontalPanel();
		final HTMLPanel html=new HTMLPanel(getHtml());
		html.setWidth("100%");
		html.setHeight("100px");
		html.setStyleName("text");
		vpanel.add(html);
		/*
		final Button bt=new Button("Hide");
		
		bt.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(html.isVisible()){
					html.setVisible(false);
					bt.setText("Show");
				}else{
					html.setVisible(true);
					bt.setText("Hide");
				}
			}
		});
		
		vpanel.add(bt);
		*/
		final PopupPanel dialog2=new PopupPanel();
		dialog2.add(vpanel);
		dialog2.setPopupPosition(150, 0);
		dialog2.setWidth("100%");
		dialog2.setStyleName("transparent");
		dialog2.show();
		
	}
	
	protected void showControl(){
		main.setVisible(true);
		hide.setVisible(true);
		rightTop(dialog);
	}
	
	public String getHtml(){
		return "Powerd by <a href='https://github.com/mrdoob/three.js/'>Three.js</a> & <a href='http://code.google.com/intl/en/webtoolkit/'>GWT</a>";
	}
	public abstract void createControl(Panel parent);
	
	private void rightTop(PopupPanel dialog){
		int w=Window.getClientWidth();
		int h=Window.getScrollTop();
		int dw=dialog.getOffsetWidth();
		//GWT.log(w+"x"+h+" offset="+dialog.getOffsetWidth());
		dialog.setPopupPosition(w-dw-18, h);
	}
	
	protected void leftBottom(PopupPanel dialog){
		int w=Window.getClientWidth();
		int h=Window.getClientHeight();
		int dw=dialog.getOffsetWidth();
		int dh=dialog.getOffsetHeight();
		//GWT.log(w+"x"+h+" offset="+dialog.getOffsetWidth());
		dialog.setPopupPosition(0, h-dh);
	}
	
	public final native void log(JavaScriptObject object)/*-{
	console.log(object);
	}-*/;
	public static final native void log(String object)/*-{
	console.log(object);
	}-*/;
}
