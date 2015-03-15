package com.akjava.gwt.three.client.java.ui;

import com.akjava.gwt.html5.client.file.ui.DropVerticalPanelBase;
import com.akjava.gwt.stats.client.Stats;
import com.akjava.gwt.three.client.gwt.renderers.WebGLRendererParameter;
import com.akjava.gwt.three.client.gwt.ui.RendererBuilder;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer.WebGLCanvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.DragLeaveEvent;
import com.google.gwt.event.dom.client.DragLeaveHandler;
import com.google.gwt.event.dom.client.DragOverEvent;
import com.google.gwt.event.dom.client.DragOverHandler;
import com.google.gwt.event.dom.client.DropEvent;
import com.google.gwt.event.dom.client.DropHandler;
import com.google.gwt.event.dom.client.HasDragLeaveHandlers;
import com.google.gwt.event.dom.client.HasDragOverHandlers;
import com.google.gwt.event.dom.client.HasDropHandlers;
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
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ScrollEvent;
import com.google.gwt.user.client.Window.ScrollHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * TODO move somewhere this is totall not part of three.js
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public abstract class TabDemoEntryPoint implements EntryPoint {

	private WebGLRenderer renderer;



	protected Timer timer;
	protected Stats stats;



	protected WebGLCanvas canvas;



	private PopupPanel dialog;



	private Button hideButton;



	protected DropVerticalPanelBase main;
	
	protected int canvasWidth,canvasHeight;



	protected TabLayoutPanel tabPanel;

	protected int tabHeight=24;

	protected PopupPanel popupPanel;
	public WebGLCanvas getCanvas() {
		return canvas;
	}
	public abstract void onDoubleClick(DoubleClickEvent event);
	public abstract void onMouseClick(ClickEvent event);
	public abstract void onMouseWheel(MouseWheelEvent event);
	public abstract void onMouseMove(MouseMoveEvent event) ;
	public abstract void onMouseDown(MouseDownEvent event) ;
	public abstract void onMouseUp(MouseUpEvent event) ;
	public abstract void onMouseOut(MouseOutEvent event);
	public abstract void update(WebGLRenderer renderer);
	public abstract void initialize(WebGLRenderer renderer,int width,int height);
	public abstract void resized(int width,int height);
	public class TabLayoutPanelWithDragAndDrop extends TabLayoutPanel implements HasDropHandlers, HasDragOverHandlers,
	HasDragLeaveHandlers{
		public TabLayoutPanelWithDragAndDrop(double barHeight, Unit barUnit) {
			super(barHeight, barUnit);
			// TODO Auto-generated constructor stub
		}

		/**
		 * 
		 */
		  @Override
		    public HandlerRegistration addDropHandler(DropHandler handler) {
		        return addBitlessDomHandler(handler, DropEvent.getType());
		    }

		    @Override
		    public HandlerRegistration addDragOverHandler(DragOverHandler handler) {
		        return addBitlessDomHandler(handler, DragOverEvent.getType());
		    }

		    @Override
		    public HandlerRegistration addDragLeaveHandler(DragLeaveHandler handler) {
		        return addBitlessDomHandler(handler, DragLeaveEvent.getType());
		    }
		
		    public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
		        return addDomHandler(handler, MouseWheelEvent.getType());
		      }
		
	}
	protected void onDrop(DropEvent event){
		event.preventDefault();
	}
	protected void onDragOver(DragOverEvent event){
		event.preventDefault();
	}
	protected void onDragLeave(DragLeaveEvent event){
		event.preventDefault();
	}
	
	public void onModuleLoad() {
		/*
		DropVerticalPanelBase rootPanel=new DropVerticalPanelBase();
		rootPanel.setSize("100%", "100%");
		
		//RootLayoutPanel.get().add(rootPanel);
		*/
		
		//support drag and drop anywhere
		tabPanel = new TabLayoutPanelWithDragAndDrop(tabHeight, Unit.PX);
		((TabLayoutPanelWithDragAndDrop)tabPanel).addDropHandler(new DropHandler() {
			@Override
			public void onDrop(DropEvent event) {
				TabDemoEntryPoint.this.onDrop(event);
			}
		});
		((TabLayoutPanelWithDragAndDrop)tabPanel).addDragOverHandler(new DragOverHandler() {
			
			@Override
			public void onDragOver(DragOverEvent event) {
				TabDemoEntryPoint.this.onDragOver(event);
			}
		});
		((TabLayoutPanelWithDragAndDrop)tabPanel).addDragLeaveHandler(new DragLeaveHandler() {
			
			@Override
			public void onDragLeave(DragLeaveEvent event) {
				TabDemoEntryPoint.this.onDragLeave(event);
			}
		});
		
		RootLayoutPanel.get().add(tabPanel);
		
		int width=Window.getClientWidth();
		int height=Window.getClientHeight()-tabHeight;
		/**
		 * 
		 * if
			com.google.gwt.core.client.JavaScriptException: (TypeError): Cannot read property 'WebGLRenderer' of undefined
			
			add lines and both js files on same directory with html
			<script type="text/javascript" language="javascript" src="Three.js"></script>
    		<script type="text/javascript" language="javascript" src="stats.js"></script>     
		 */
		//renderer = RendererBuilder.createRenderer();//stop using it cant' contain args
		renderer = THREE.WebGLRenderer(WebGLRendererParameter.create().alpha(true));
		//renderer = THREE.WebGLRenderer(GWTRenderObject.create().preserveDrawingBuffer()); //crash browser?
		renderer.setSize(width,height);
		
		
		//renderer.setClearColorHex(0x333333, 1);
		
		//RootLayoutPanel.get().setStyleName("transparent");
		
		canvas = new WebGLCanvas(renderer);
		
		//canvas.setClearColorHex(0);
		//final FocusPanel glCanvas=new FocusPanel(canvas);
		
		canvas.addMouseUpHandler(new MouseUpHandler() {
			
			@Override
			public void onMouseUp(MouseUpEvent event) {
			
				TabDemoEntryPoint.this.onMouseUp(event);
			}
		});

		canvas.addDoubleClickHandler(new DoubleClickHandler() {
			
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				TabDemoEntryPoint.this.onDoubleClick(event);
			}
		});

		canvas.addMouseWheelHandler(new MouseWheelHandler() {
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				TabDemoEntryPoint.this.onMouseWheel(event);
			}
		});
		//hpanel.setFocus(true);
		
		
		canvas.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				TabDemoEntryPoint.this.onMouseClick(event);
			}
		});
		
		canvas.addMouseDownHandler(new MouseDownHandler() {
			
			@Override
			public void onMouseDown(MouseDownEvent event) {
				TabDemoEntryPoint.this.onMouseDown(event);
				
			}
		});
		
		canvas.addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				TabDemoEntryPoint.this.onMouseOut(event);
			}
		});
		
		canvas.addMouseMoveHandler(new MouseMoveHandler(){

			@Override
			public void onMouseMove(MouseMoveEvent event) {
				TabDemoEntryPoint.this.onMouseMove(event);
			}});
		
		
		
		//canvas.setStyleName("clear");
		//glCanvas.getElement().getStyle().setBackgroundColor("#fff");
		canvas.setWidth("100%");
		canvas.setHeight("100%");
		
		tabPanel.add(canvas,getTabTitle());
		//tabPanel.add(new Label("hello"),"test");
		//RootLayoutPanel.get().add(canvas);
		
		canvasWidth=width;
		canvasHeight=height;
		//log("initialize:"+width+"x"+height);
		initialize(renderer,width,height);
		
		stats = Stats.insertStatsToRootPanel();
		stats.setPosition(0, 30);//for tab header
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
		main = new DropVerticalPanelBase();
		main.setVisible(false);
		
		
		HorizontalPanel hPanel=new HorizontalPanel();
		hPanel.setWidth("100%");
		hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_RIGHT);
		dialogRoot.add(hPanel);
		hideButton = new Button("Hide Control");
		
		hideButton.setVisible(false);
		hideButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				main.setVisible(false);
				hideButton.setVisible(false);
				rightTop(dialog);
			}
		});
		hPanel.add(hideButton);
		
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
				//int w=canvas.getOffsetWidth();
				//int h=canvas.getOffsetHeight()-tabHeight;
				int w=Window.getClientWidth();
				int h=Window.getClientHeight()-tabHeight;
				
				if(w<=0 || h<=0){
					//log("ignore 0 resize");
					return;
				}
				canvasWidth=w;
				canvasHeight=h;
				resized(w,h);
				renderer.setSize(w, h);
				rightTop(dialog);
			}
		});
		Window.addWindowScrollHandler(new ScrollHandler() {
			
			@Override
			public void onWindowScroll(ScrollEvent event) {
				//log("scroll:"+event.getScrollLeft()+"x"+event.getScrollTop());
			}
		});
		
		
		HTMLPanel html=new HTMLPanel(getHtml());
		html.setWidth("100%");
		html.setHeight("20px");
		html.setStyleName("text");
		popupPanel = new PopupPanel();
		popupPanel.add(html);
		popupPanel.setPopupPosition(150, 35);
		popupPanel.setWidth("100%");
		popupPanel.setStyleName("transparent");
		popupPanel.show();
		
	}
	
	
	protected void showControl(){
		main.setVisible(true);
		hideButton.setVisible(true);
		rightTop(dialog);
	}
	
	protected void hideControl(){
		main.setVisible(false);
		hideButton.setVisible(false);
		
	}
	
	public String getHtml(){
		return "Created with <a href='https://github.com/mrdoob/three.js/'>Three.js</a> & <a href='http://code.google.com/intl/en/webtoolkit/'>GWT</a>";
	}
	public abstract void createControl(DropVerticalPanelBase parent);
	
	public abstract String getTabTitle();
	
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
		//log("left-bottom:"+h+","+dh);
		dialog.setPopupPosition(0, h-dh-tabHeight);//some error
	}
	

	


}
