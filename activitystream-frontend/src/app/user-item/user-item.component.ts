import { Component, OnInit, Input } from '@angular/core';
import { MessagesService } from '../services/messages.service';
import { User } from '../models/User';
import { Router } from "@angular/router";
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-user-item',
  templateUrl: './user-item.component.html',
  styleUrls: ['./user-item.component.css']
})
export class UserItemComponent implements OnInit {

  @Input() user: User;
  firstName: string;
  lastName: string;
  username: string;

  constructor(private router: Router, private messagesService: MessagesService, private messageService: MessageService) { }

  ngOnInit(user = this.user) {
    this.username = user.username;
    this.firstName = user.firstName;
    this.lastName = user.lastName;
  }

  goToMessage(username: string){
    this.messageService.clear();
    this.messagesService.getUserMessages(username);
  }

}
