//
//  DetailsViewController.swift
//  SmartTour
//
//  Created by Ishan Sarangi on 11/23/19.
//  Copyright © 2019 Ishan Sarangi. All rights reserved.
//

import UIKit
import Alamofire

class DetailsViewController: UIViewController {

    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var artworkImageView: UIImageView!
    @IBOutlet weak var artworkAccessionNumber: UILabel!
    @IBOutlet weak var artworkDateAcquired: UILabel!
    @IBOutlet weak var artworkMedium: UILabel!
    @IBOutlet weak var artworkClassification: UILabel!
    @IBOutlet weak var artistName: UILabel!
    @IBOutlet weak var artistGender: UILabel!
    @IBOutlet weak var artistBio: UILabel!
    
    var artwork: Artwork?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        if let art = artwork {
            updateViews(art)
        }
    }

    func updateViews(_ art: Artwork){
        titleLabel.text = art.title
        load(urlStr: art.thumbnailURL)
        artworkAccessionNumber.text = art.accessionNumber
        artworkDateAcquired.text = art.dateAcquired
        artworkMedium.text = art.medium
        artworkClassification.text = art.classification
        artistName.text = art.artistName + " " + art.beginEndDate
        artistGender.text = art.gender
        artistBio.text = art.artistBio
    }
    
    func load(urlStr: String) {
            AF.request(urlStr, method: .get)
            .validate()
            .responseData(completionHandler: { (responseData) in
                DispatchQueue.main.async {
                    self.artworkImageView.image = UIImage(data: responseData.data!)
                }
            })
    }
}
