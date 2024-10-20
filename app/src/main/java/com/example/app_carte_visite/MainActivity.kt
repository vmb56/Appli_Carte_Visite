package com.example.app_carte_visite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.draw.clip
import com.example.app_carte_visite.ui.theme.App_Carte_VisiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_Carte_VisiteTheme {
                // Interface de la carte de visite avec fond
                BackgroundCardView()
            }
        }
    }
}

// Fonction pour insérer une image de profil
@Composable
fun ProfileImage() {
    val image = painterResource(R.drawable.img_first)
    Image(
        painter = image,
        contentDescription = "Profile picture",
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun BackgroundCardView() {
    val img = painterResource(R.drawable.back_image)
    // Utilisation de Box pour ajouter un arrière-plan
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = img,
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.3f
        )

        // Contenu de la carte de visite
        // Partie centrale : Informations de profil
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center // Centre verticalement et horizontalement
        ) {
            ProfileSection()
        }

        // Partie du bas : Informations de contact
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomCenter // Place en bas au centre
        ) {
            ContactSection()
        }
    }
}

@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Appel de la fonction ProfileImage pour l'image de profil
        ProfileImage()

        Spacer(modifier = Modifier.height(8.dp))

        // Nom complet
        Text(
            text = "BAMBA MOUHAMMAD VALY",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            textAlign = TextAlign.Center // Texte centré horizontalement
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Titre
        Text(
            text = "DEVELOPPEUR D'APPLICATION",
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Blue,
            textAlign = TextAlign.Center // Texte centré horizontalement
        )
    }
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Contact: Téléphone
        ContactInfo(icon = Icons.Filled.Call, info = "+225 07 59 86 08 74", contentDescription = "Call Icon")

        // Contact: Réseaux sociaux
        ContactInfo(icon = Icons.Filled.Share, info = "bamba0073270@univmetiers.ci", contentDescription = "Social Media Icon")

        // Contact: Email
        ContactInfo(icon = Icons.Filled.Email, info = "valybamba56@gmail.com", contentDescription = "Email Icon")

        // Contact: lieu
        ContactInfo(icon = Icons.Filled.Place, info = "PIGIER CI", contentDescription = "Place Icon")
    }
}

@Composable
fun ContactInfo(icon: ImageVector, info: String, contentDescription: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color(0xFF3ddc84), // Couleur pour l'icône en vert
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = info,
            fontSize = 18.sp,
            textAlign = TextAlign.Center // Texte centré horizontalement dans le composant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    App_Carte_VisiteTheme {
        BackgroundCardView()
    }
}
