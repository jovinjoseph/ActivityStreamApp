
import { Component, OnInit, OnChanges } from '@angular/core';
import { MessagesService } from '../services/messages.service';
import { Observable } from 'rxjs/Observable';
import { Message } from '../models/Message';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-message-feed',
  templateUrl: './message-feed.component.html',
  styleUrls: ['./message-feed.component.css']
})
export class MessageFeedComponent implements OnInit , OnChanges {

  public feed: any[] = [];
  constructor(private router: Router, private route: ActivatedRoute, public messagesService: MessagesService)
   { 
    this.messagesService.getMessageSubject().subscribe(res => {
			if (res) {
        this.feed = res;			}
		});
  }

  ngOnInit() {
    this.messagesService.getMessageSubject().subscribe(res => {
      console.log("feed  init"+ res);
			if (res) {
        this.feed = res;
  
			}
    });
  }

  ngOnChanges() {
    this.messagesService.getMessageSubject().subscribe(res => {
			if (res) {
				this.feed = res;
			}
		});
  }

}

