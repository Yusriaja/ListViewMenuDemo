package in.cycorax.listviewmenudemo.ws;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class InvokeWebService {
	// Namespace of the Webservice - can be found in WSDL
	private static String NAMESPACE = "http://main.followup.com/";
	// Webservice URL - WSDL File location
	private static String URL = "http://10.19.9.190:9991/FollowUp/SaleCityFilterService?wsdl";
	// SOAP Action URI again Namespace + Web method name
	private static String SOAP_ACTION = "http://main.followup.com/";

	public static String invokeHelloWorldWS() {
		String name = "Virendra";
		String webMethName = "getConcatenatedString";
		String resTxt = null;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo sayHelloPI = new PropertyInfo();

		// Set Name
		sayHelloPI.setName("name");
		// Set Value
		sayHelloPI.setValue(name);
		// Set dataType
		sayHelloPI.setType(String.class);
		// Add the property to request object
		request.addProperty(sayHelloPI);
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION + webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to resTxt variable static variable
			resTxt = response.toString();

		} catch (Exception e) {
			// Print error
			e.printStackTrace();
			// Assign error message to resTxt
			resTxt = "Error occured";
		}
		// Return resTxt to calling object
		return resTxt;
	}
}
