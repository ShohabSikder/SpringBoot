import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {SnackbarHelper} from "../helper/snackbar.helper";

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent {

  constructor(
    private router: Router,
    private snackbarHelper: SnackbarHelper
  ) { }


  loginComponent = true;

  login(){
    this.snackbarHelper.openSuccessSnackBar();
    this.router.navigate(['/adminPanelComponent']);
    this.loginComponent = false;
  }

  goToregister(){
    this.loginComponent = false;
    this.router.navigate(['/registerComponent']);
  }
}
