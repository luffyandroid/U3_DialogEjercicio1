package com.example.didact.u3_dialogejercicio1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by DIDACT on 13/02/2018.
 */

public class DialogConfirmacion  extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("¿Deseas elimninar la opcion?")
                .setTitle("ELIMINAR")
                .setPositiveButton("Si", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Has eliminado", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "No has eliminado", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}