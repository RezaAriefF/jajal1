package training;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.softwareag.util.IDataMap;
// --- <<IS-END-IMPORTS>> ---

public final class javaServices

{
	// ---( internal utility methods )---

	final static javaServices _instance = new javaServices();

	static javaServices _newInstance() { return new javaServices(); }

	static javaServices _cast(Object o) { return (javaServices)o; }

	// ---( server methods )---




	public static final void demoDocjavaServices (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(demoDocjavaServices)>> ---
		// @sigtype java 3.5
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String PONumber = "";
		String SenderID = "";
		String Description = "";
		
			// demoDoc
			IData	demoDoc = IDataUtil.getIData( pipelineCursor, "demoDoc" );
			if ( demoDoc != null)
			{
				IDataCursor demoDocCursor = demoDoc.getCursor();
						PONumber = IDataUtil.getString( demoDocCursor, "PONumber" );
						SenderID = IDataUtil.getString( demoDocCursor, "SenderID" );
		
					// i.items
					IData[]	items = IDataUtil.getIDataArray( demoDocCursor, "items" );
					if ( items != null)
					{
						for ( int i = 0; i < items.length; i++ )
						{
							IDataCursor itemsCursor = items[i].getCursor();
									Description = IDataUtil.getString( itemsCursor, "Description" );
								String	Quantity = IDataUtil.getString( itemsCursor, "Quantity" );
							itemsCursor.destroy();
						}
					}
				demoDocCursor.destroy();
			}
		pipelineCursor.destroy();
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		
		// outdemoDoc
		IData	outdemoDoc = IDataFactory.create();
		IDataCursor outdemoDocCursor = outdemoDoc.getCursor();
		IDataUtil.put( outdemoDocCursor, "PONumber", PONumber );
		
		// outdemoDoc.items
		IData[]	items_1 = new IData[1];
		items_1[0] = IDataFactory.create();
		IDataCursor items_1Cursor = items_1[0].getCursor();
		IDataUtil.put( items_1Cursor, "Description", Description );
		items_1Cursor.destroy();
		IDataUtil.put( outdemoDocCursor, "items", items_1 );
		outdemoDocCursor.destroy();
		IDataUtil.put( pipelineCursor_1, "outdemoDoc", outdemoDoc );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void myFirstjavaServices (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(myFirstjavaServices)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [o] field:0:required outputString
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String	inputString = IDataUtil.getString( pipelineCursor, "inputString" );
		pipelineCursor.destroy();
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "outputString", "inputString" );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void mySeccondjavaServices (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(mySeccondjavaServices)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [o] field:0:required outputString
		// pipeline
		IDataMap idm= new IDataMap(pipeline);
		String inputString= idm.getAsNonEmptyString("inputString");
		
		idm.put("outputString", inputString);
		// --- <<IS-END>> ---

                
	}
}

