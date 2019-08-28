import { Component, OnInit, ViewChild, ElementRef, AfterViewChecked } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from "@angular/router";
import "rxjs/add/operator/switchMap";
import { MessagesService } from '../services/messages.service';

@Component({
  selector: 'app-chatroom',
  templateUrl: './chatroom.component.html',
  styleUrls: ['./chatroom.component.css']
})
export class ChatroomComponent implements OnInit, AfterViewChecked {
  @ViewChild('scroller') private feedContainer: ElementRef;
  username: string;
  constructor(	private router: Router, private route: ActivatedRoute, private messagesService: MessagesService) { }

  ngOnInit() {
  }

  scrollToBottom(): void {
    this.feedContainer.nativeElement.scrollTop
    = this.feedContainer.nativeElement.scrollHeight;
  }

  ngAfterViewChecked() {
    this.scrollToBottom();
  }
}
