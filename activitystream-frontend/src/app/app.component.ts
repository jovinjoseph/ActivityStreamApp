import { Component, ViewChild } from "@angular/core";
import { Router, RouterLink } from "@angular/router";
import { LoginComponent } from "./login/login.component";
@Component({
	selector: "app-root",
	templateUrl: "./app.component.html",
	styleUrls: ["./app.component.css"]
})
export class AppComponent {
	public isUserLoggedIn = false;
	constructor( private router: Router) {
		
	}
	ngOnInit(){
		this.isUserLoggedIn = localStorage.getItem("jwt_token") === null ? false : true;
	}
	public navigateTo() {
		const link = ["/message"];
		this.router.navigate(link);
	}
}