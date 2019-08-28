import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { AuthGuard } from "./../services/auth-guard.service";
import { ChatroomComponent } from "./../chatroom/chatroom.component";
import { LoginComponent } from "./../login/login.component";
import { LogoutComponent } from "./../logout/logout.component";
import { RegisterComponent } from "./../register/register.component";
import { CreateCircleComponent } from "./../create-circle/create-circle.component";
import { MessagesComponent } from "../messages/messages.component";
import { MessageComponent } from "../message/message.component";

const routes: Routes = [
	{path: "circle",component: CreateCircleComponent,canActivate: [AuthGuard]},
	{ path: "login", component: LoginComponent },
	{ path: "", redirectTo :'/login',pathMatch : 'full' },
	{ path: "register", component: RegisterComponent },
	{ path: "logout", component: LogoutComponent },
	{ path: "alert", component: MessageComponent },
	{ path: "message", component: ChatroomComponent,canActivate: [AuthGuard] },
];
@NgModule({
	imports: [RouterModule.forRoot(routes, {useHash: true})],
	exports: [RouterModule]
})
export class AppRoutingModule {}