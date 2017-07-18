package com.hz.lvbaolin.ws.webservice;

import com.hz.lvbaolin.ws.domain.Person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by master-lv on 2017/7/14.
 */
@WebService
public interface PersonService {
    @WebMethod
    String getName(@WebParam(name = "userId") Long userId);
    @WebMethod
    Person getPerson(Long userId);
}
