import { Injectable } from "@angular/core";
import { Headers, Http, Jsonp } from "@angular/http";
import "rxjs/Rx";
import { ActivityHttpClient } from "./activityhttpclient.service";

@Injectable()
export class UserService {
	
private serviceUrl = "http://localhost:8083/api/user/";

constructor(private http: ActivityHttpClient) {}

getAllUsers() {
	const url = this.serviceUrl;
	return this.http.get(url).toPromise().then(res => res.json(),
		err => err.json());
	}

	private handleError(error: any) {
	}
}