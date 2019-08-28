import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LogoutComponent implements OnInit {
  constructor(private router: Router) {
    localStorage.removeItem('jwt_token');
    localStorage.removeItem('username');
    window.location.reload();
    this.router.navigate(['']);
  }
  public ngOnInit() {}
}