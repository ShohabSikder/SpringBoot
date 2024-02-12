import {Injectable} from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';
import {
  ERROR,
  FAILED_SAVE,
  OK, OK_BN,
  LOGIN_SUCCESSFUL,
} from './constant/message';

@Injectable({
  providedIn: 'root'
})
export class SnackbarHelper {
  isEnLabel: boolean | undefined;

  constructor(private snackBar: MatSnackBar) {
  }

  openSuccessSnackBar(): void {
    this.snackBar.open(LOGIN_SUCCESSFUL, OK, {
      duration: 5000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['success-snackbar']
    });
  }

  openSuccessSnackBarWithMessage(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 5000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['success-snackbar']
    });
  }

  openErrorSnackBar(): void {
    this.snackBar.open(FAILED_SAVE, ERROR, {
      duration: 5000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['error-snackbar']
    });
  }

  openErrorSnackBarWithMessage(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 5000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['error-snackbar']
    });
  }
  openWarnSnackBarWithMessage(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 5000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
      panelClass: ['warn-snackbar']
    });
  }

  openSuccessSnackBarWithMessageEnBn(message: string, messageBn: string): void {
    if (this.isEnLabel) {
      this.openSuccessSnackBarWithMessage(message, OK);
    } else {
      this.openSuccessSnackBarWithMessage(messageBn, OK_BN);
    }
  }

  openWarnSnackBarWithMessageEnBn(message: string, messageBn: string): void {
    if (this.isEnLabel) {
      this.openWarnSnackBarWithMessage(message, 'OK');
    } else {
      this.openWarnSnackBarWithMessage(messageBn, OK_BN);
    }
  }

  openErrorSnackBarWithMessageEnBn(message: string, messageBn: string): void {
    if (this.isEnLabel) {
      this.openErrorSnackBarWithMessage(message, 'OK');
    } else {
      this.openErrorSnackBarWithMessage(messageBn, OK_BN);
    }
  }
}
