package com.unilever.api.unileverheartbeatapi.controlller;

import com.unilever.api.unileverheartbeatapi.model.*;
import com.unilever.api.unileverheartbeatapi.service.HeartBeatService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/heartbeat")
public class HeartBeatRestController {


	@Autowired
	private HeartBeatService heartBeatService;

		@ApiOperation(value = "Returns Combined Response of Otm to PI and PI to OTM for Specific Server",response = OtmPiAndPiOtm.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/otmpiandpiotm/{servername}", method= RequestMethod.GET, produces = "application/json")
	public List<OtmPiAndPiOtm> getOtmPiAndPiOtmForAllDB(@PathVariable String servername) {

		return heartBeatService.getOtmPiAndPiOtmForAllDB(servername);
	}


	@ApiOperation(value = "Returns Response of Otm to PI",response = OtmToPi.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/otmtopi/{dbname}", method= RequestMethod.GET, produces = "application/json")
	public OtmToPi getOtmToPiFromDataSource(@PathVariable String dbname) {

		return heartBeatService.getOtmToPiFromDataSource(dbname);
	}

	@ApiOperation(value = "Returns Response of PI to OTM",response = PiToOtm.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/pitootm/{dbname}", method= RequestMethod.GET, produces = "application/json")
	public PiToOtm getPiToOtmFromDataSource(@PathVariable String dbname) {
		return heartBeatService.getPiToOtmFromDataSource(dbname);
	}



	@ApiOperation(value = "Return List of ThresholdReport",response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/thresholdreport/{dbname}", method= RequestMethod.GET, produces = "application/json")
	public List<ThresholdReport> getThresholdReport(@PathVariable String dbname) {
		return heartBeatService.getThresholdReport(dbname);
	}

	@ApiOperation(value = "Return List of ConnectivityReport",response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/connectivityreport/{dbname}", method= RequestMethod.GET, produces = "application/json")
	public List<ConnectivityReport> getConnectivityReport(@PathVariable String dbname) {
		return heartBeatService.getConnectivityReport(dbname);
	}

	@ApiOperation(value = "Return List of Threshold and Connectivity Report",response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/report/{serverName}", method= RequestMethod.GET, produces = "application/json")
	public List<Report> getReport(@PathVariable String serverName) {
		return heartBeatService.getReport(serverName);
	}
}
