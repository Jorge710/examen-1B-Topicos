import { Component, OnInit } from '@angular/core';
import { AuthService } from "../auth.service";

import {interval} from 'rxjs';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})

export class SignInComponent implements OnInit {
  
  constructor(public authService: AuthService) { 
    
  }
  ngOnInit() { 
    const time = interval(8333);
  }

  authServiceGoogleAuth(){
    console.log('Goolge');
  }
}