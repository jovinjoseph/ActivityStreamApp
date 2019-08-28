import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { HttpInterceptor, HTTP_INTERCEPTORS} from "@angular/common/http";
import {  } from '@angular/material/grid-list';
import {  } from '@angular/material/form-field';
import {  } from '@angular/material/button';
import { MatGridListModule, 
         MatFormFieldModule,
         MatSelectModule,
         MatOptionModule,
         MatIconModule,
         MatButtonModule,
         MatButtonToggleModule } 
from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AuthService } from './services/auth.service';
import { MessageService } from './services/message.service';
import { MessagesService } from './services/messages.service';
import { CircleService } from './services/circle.service';
import { UserService} from './services/user.service';

import { AppComponent } from './app.component';
import { CircleComponent } from './circle/circle.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MessageComponent } from './message/message.component';
import { MessagesComponent } from './messages/messages.component';
import { MessageFormComponent } from './message-form/message-form.component';
import { ChatroomComponent } from './chatroom/chatroom.component';
import { MessageFeedComponent } from './message-feed/message-feed.component';
import { RegisterComponent } from './register/register.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserItemComponent } from './user-item/user-item.component';
import { MessageCircleComponent } from './message-circle/message-circle.component';

import { AuthGuard } from './services/auth-guard.service';
import { ActivityHttpClient} from './services/activityhttpclient.service';
import { CreateCircleComponent } from './create-circle/create-circle.component';
  

@NgModule({
  declarations: [
    AppComponent,
  MessageFormComponent,
  NavbarComponent,
  LoginComponent,
  RegisterComponent,
  LogoutComponent,
  MessagesComponent,
  CreateCircleComponent,
  CircleComponent,
  ChatroomComponent,
  MessageFeedComponent,
  MessageComponent,
  UserListComponent,
  UserItemComponent,
  MessageCircleComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpModule,
    HttpClientModule,
    FormsModule,
    MatGridListModule,
    MatFormFieldModule,
    MatSelectModule,
    MatOptionModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatIconModule,
    RouterModule,
  ],
  providers: [UserService, MessagesService, CircleService, AuthGuard, MessageService,AuthService,ActivityHttpClient],
  bootstrap: [AppComponent]
})
export class AppModule {}