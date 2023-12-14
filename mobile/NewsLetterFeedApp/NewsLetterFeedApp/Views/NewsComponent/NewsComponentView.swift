//
//  NewsComponentView.swift
//  NewsLetterFeedApp
//
//  Created by Matheus Henrique Mendes Alexandre on 12/12/23.
//

import SwiftUI
import SDWebImageSwiftUI

struct NewsComponentView: View {
    var chapeu: String
    var title: String
    var imageURL: String?
    var metadata: String
    var summary: String
    
    let imageView = SDAnimatedImageView()
    
    var body: some View {
        VStack {
            Text(chapeu)
                .font(.caption)
                .padding()
            
            Text(title)
                .font(.title2)
            if let imageURL = URL(string: imageURL ?? ""){
                VStack {
                    WebImage(url: imageURL)
                        .resizable()
                        .scaledToFit()
                        .frame(width: 308, height: 198)
                }
            }
            Text(metadata)
                .font(.caption)
                .padding(.bottom)
            
            Text(summary)
                .font(.body)
            Spacer()
        }
    }
}
