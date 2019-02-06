package sk.upjs.ics.evidencia_sprostredkovatela_rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import sk.upjs.ics.evidencia_sprostredkovatela.persistent.GroupNotFoundException;

@ControllerAdvice
public class GroupAdvice {
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleDaoException(NumberFormatException e) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(), "Object id should be a number");
	}

	@ExceptionHandler(GroupNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError handleGroupNotFoundException(GroupNotFoundException e) {
		return new ApiError(HttpStatus.NOT_FOUND.value(), "Group with id = " + e.getGroupId() + " not found");

	}
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(), 
				"Group is not in right format: " + e.getMessage());
	}

	@ExceptionHandler(DaoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleDaoException(DaoException e) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(), 
				"Group is not in right format: " + e.getCause().getMessage());
	}
}

