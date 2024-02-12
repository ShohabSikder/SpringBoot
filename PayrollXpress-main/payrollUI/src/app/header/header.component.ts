import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {SnackbarHelper} from "../helper/snackbar.helper";
import {LOGOUT, OK} from "../helper/constant/message";
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(
    private router: Router,
    private snackbarHelper: SnackbarHelper
  ) { }

  logout(){
      this.snackbarHelper.openErrorSnackBarWithMessage(LOGOUT, OK);
      this.router.navigate(['/logInComponent']);

  }
}
